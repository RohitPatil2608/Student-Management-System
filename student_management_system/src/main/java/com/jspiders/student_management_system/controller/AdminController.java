package com.jspiders.student_management_system.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.student_management_system.pojo.AdminPOJO;
import com.jspiders.student_management_system.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	//..............................Login controller............................................
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map, HttpSession session) {
		AdminPOJO pojo = service.login(username, password);
		if (pojo != null) {
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(300);
			return "HomePage";
		}
		map.addAttribute("msg", "Invalid credentials...!!! Try again...!!!");
		return "LoginPage";
	}
	
	//................................Create page controller.........................................
	@GetMapping("/createAdmin")
	public String createPage(ModelMap map) {
		List<AdminPOJO> admin = service.getAdmin();
		if (admin.isEmpty()) {
			return "CreateAccount";
		}
		map.addAttribute("msg", "Admin account already exists...!!!");
		return "LoginPage";
	}
	
	//..................................Create account controller...........................................
	@PostMapping("/createAdmin")
	public String createAdmin(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPOJO pojo = service.addAdmin(username, password);
		if (pojo != null) {
			map.addAttribute("msg", "Admin account created...Login now..!!!");
			return "LoginPage";
		}
		map.addAttribute("msg", "Failed to create account...Try again...!!!");
		return "CreateAccount";
	}
	
	//..................................Logout controller....................................................
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("msg" , "Logged out successfully...!!!");
		return "LoginPage";
	}
	
}