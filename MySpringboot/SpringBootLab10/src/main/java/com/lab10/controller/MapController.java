package com.lab10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lab10.domain.Emp;


@Controller 
public class MapController { 
	
	@Value("${google.map.api-key}") 
		private String apiKey; 
	
	@GetMapping("/map") 
		public String showMapPage(Model model) { 
		model.addAttribute("apiKey", apiKey); 
		return "map";  
	} 
	

}