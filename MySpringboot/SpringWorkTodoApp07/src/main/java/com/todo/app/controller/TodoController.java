package com.todo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@Controller
public class TodoController {

	@Autowired
	TodoMapper todoMapper;
	
	@RequestMapping(value="/") //동일한 context url이 있으면 충돌 날 수 있음 => @PostMapping, @GetMapping등으로 명시하는것이 좋음
	public String index(Model model) {
		//List<Todo> list = todoMapper.selectAll();
		List<Todo> list = todoMapper.selectIncomplete(); //미완료 작업 조회
		List<Todo> doneList = todoMapper.selectComplete(); //완료 작업 조회
		model.addAttribute("todos", list);
		model.addAttribute("doneTodos", doneList);
		return "index"; 
	}
	
	@RequestMapping(value="/add")
	public String add(Todo todo) {
		todoMapper.add(todo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/update")
	public String update(Todo todo) {
		todoMapper.update(todo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete")
	public String delete(Todo todo) {
		todoMapper.delete(todo);
		return "redirect:/";
	}
	
}
