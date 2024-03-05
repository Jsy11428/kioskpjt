package com.office.kiosk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {

	@GetMapping({"", "/"})
	public String home() {
		log.info("home()");
	
		String nextPage = "/home";
		
		return nextPage;
		
	}
	
	@GetMapping({"/franchisee/home","/franchisee", "/franchisee/"})
	public String franchiseeHome() {
		log.info("franchiseeHome()");
	
		String nextPage = "/franchisee/franchisee_home";
		
		return nextPage;
		
	}
	
	@GetMapping({"/admin/home", "/admin/", "/admin"})
	public String adminHome() {
		log.info("adminHome()");
	
		String nextPage = "/admin/admin_home";
		
		return nextPage;
		
	}
	
	
}