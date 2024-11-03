package com.mlr.mart.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
}
