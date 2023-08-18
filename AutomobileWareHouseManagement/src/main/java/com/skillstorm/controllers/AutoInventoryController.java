package com.skillstorm.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autoinventorycontrol")
public class AutoInventoryController {
	
	
	
	@GetMapping("/warehouses")
	public String getWarehouses(Model model)
	{
		model.addAttribute(List<WareHouse>, );
		return "warehouses";
	}

}
