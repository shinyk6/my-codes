package com.sec03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomEventController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public String register(@RequestParam String name, @RequestParam String email) {
		orderService.createOrder(name, email); 
		return "Order created : " + name + ":" + email;
	}
}
