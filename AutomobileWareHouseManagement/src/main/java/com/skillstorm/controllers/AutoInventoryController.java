package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.services.CarMakeServiceImpl;
import com.skillstorm.services.WareHouseServiceImpl;

@Controller
@RequestMapping("/autoinventorycontrol")
public class AutoInventoryController {
		
	@Autowired
	private WareHouseServiceImpl wareHouseServiceImpl;
	
	@Autowired
	private CarMakeServiceImpl carMakeServiceImpl;
	
	/*
	 * @Autowired public AutoInventoryController(WareHouseServiceImpl
	 * wareHouseServiceImpl) { this.wareHouseServiceImpl = wareHouseServiceImpl; }
	 */
	Logger logger = LoggerFactory.getLogger(getClass()); 
	
	/*
	 * @RequestMapping("/warehouses") public String getWarehouses(Model model) {
	 * 
	 * logger.info("Entered"); List<WareHouseResponseDTO> whdtolist = new
	 * ArrayList<>();
	 * 
	 * whdtolist = wareHouseServiceImpl.findAll();
	 * 
	 * model.addAttribute("warehouses",whdtolist);
	 * 
	 * logger.info("hello" +whdtolist.toString()); logger.info("redirecting");
	 * return "warehouses"; }
	 */
	

	@RequestMapping("/warehouses") 
	  public String getWarehouses(Model model) {
		
		logger.info("Entered");
		  List<WareHouseResponseDTO> whdtolist = new ArrayList<>();
					
		  whdtolist = wareHouseServiceImpl.findAll();
		  
		  model.addAttribute("warehouses",whdtolist);
		  
		  logger.info("hello" +whdtolist.toString());
		  logger.info("redirecting");
	  return "warehouses"; 
	  }
	
	
	
	@RequestMapping("/inventory/{warehouseId}")
	public String getmake(@PathVariable String warehouseId, Model model) {
		
		logger.info("warehouseId: "+warehouseId);
		
		List<CarMakeDTO> dtolist = new ArrayList<>();
		String warehouseLoc = "";
		
		
		
		dtolist = carMakeServiceImpl.findByWareHouseId(Integer.valueOf(warehouseId));
		
		for(CarMakeDTO dto : dtolist)
		{
			logger.info("***********warehouseLoc "+warehouseLoc);
			logger.info("**********"+dto.toString());
			warehouseLoc = dto.getWarehouseLocation();
		}
		
		logger.info(dtolist.toString());
		model.addAttribute("carmakelist", dtolist);
		
		
		model.addAttribute("warehouseLoc", warehouseLoc);
		
		return "carinventory";
	}
	
	@RequestMapping("/showinventorydetails/{carmakeid}")
	public @ResponseBody CarMakeDTO  getInventoryDetails(@PathVariable String carmakeId) {
		
		//AjaxResponseBody result new AjaxResponseBody();
		
		return null;
	}
	
	
	 
}
