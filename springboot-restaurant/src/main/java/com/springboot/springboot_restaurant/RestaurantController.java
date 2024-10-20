package com.springboot.springboot_restaurant;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class RestaurantController{
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome!";
	}
	@GetMapping("/secured")
	public String secured()
	{
		return "Hello, Secured!";
	}
	//input custom
}
