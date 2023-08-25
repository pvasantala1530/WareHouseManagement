package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.mappers.CarInventoryDTOMapper;
import com.skillstorm.models.CarInventory;
import com.skillstorm.models.CarMake;
import com.skillstorm.services.CarInventoryServiceImpl;
import com.skillstorm.services.CarMakeServiceImpl;
import com.skillstorm.services.WareHouseServiceImpl;

@Controller
@RequestMapping("/autoinventorycontrol")
public class AutoInventoryController {

	@Autowired
	private WareHouseServiceImpl wareHouseServiceImpl;

	@Autowired
	private CarMakeServiceImpl carMakeServiceImpl;

	@Autowired
	private CarInventoryServiceImpl carInventoryServiceImpl;

	/*
	 * @Autowired public AutoInventoryController(WareHouseServiceImpl
	 * wareHouseServiceImpl) { this.wareHouseServiceImpl = wareHouseServiceImpl; }
	 */
	Logger logger = LoggerFactory.getLogger(getClass());

	

	@GetMapping("/warehouses")
	public String getWarehouses(Model model) {

		logger.info("Entered");
		List<WareHouseResponseDTO> whdtolist = new ArrayList<>();

		whdtolist = wareHouseServiceImpl.findAll();

		model.addAttribute("warehouses", whdtolist);

		logger.info("hello" + whdtolist.toString());
		logger.info("redirecting");
		return "warehouses";
	}

	@GetMapping("/inventory/{warehouseId}")
	public String getmake(@PathVariable String warehouseId, Model model) {

		logger.info("warehouseId: " + warehouseId);

		List<CarMakeDTO> dtolist = new ArrayList<>();
		String warehouseLoc = "";

		dtolist = carMakeServiceImpl.findByWareHouseId(Integer.valueOf(warehouseId));

		for (CarMakeDTO dto : dtolist) {
			logger.info("***********warehouseLoc " + warehouseLoc);
			logger.info("**********" + dto.toString());
			warehouseLoc = dto.getWarehouseLocation();
			warehouseId = String.valueOf(dto.getWarehouseId());
		}

		logger.info(dtolist.toString());
		model.addAttribute("carmakelist", dtolist);
		model.addAttribute("warehouseLoc", warehouseLoc);
		model.addAttribute("warehouseId", warehouseId);
		
		return "carinventory";
	}
	
	@GetMapping("/inventory/edit/{inventoryid}/{carmakeid}")//{color}/{price}/{quantity}/{model}")
	public String editInventory(@PathVariable String inventoryid,@PathVariable String carmakeid,Model model){//,@PathVariable String color,@PathVariable String model,@PathVariable int quantity,
			//athVariable int price,@PathVariable int carmakeid,Model model1) {
		
			model.addAttribute("carmakeid", carmakeid);
		model.addAttribute("invid", inventoryid);
		
		logger.info("(((((((((((((((((((()))))))))))))"+inventoryid+"------"+carmakeid);
		
		model.addAttribute("carinv", carInventoryServiceImpl.getCarInventory(Integer.valueOf(inventoryid)));
		
		return "updateinventory";
				
	}
	
	@PostMapping("updateinventory/{inventoryid}/{carmakeid}")
	public String updateInventory(@ModelAttribute("carinv") CarInventory ci, @PathVariable String inventoryid,
			@PathVariable String carmakeid) {
		carInventoryServiceImpl.updateCarInventory(ci, inventoryid, carmakeid);
		return "redirect:/autoinventorycontrol/warehouses";
		 }
	
	@GetMapping("deleteinventory/{inventoryid}")
	public String deleteInventory(@PathVariable String inventoryid)
	{
		
		carInventoryServiceImpl.deleteCarInventoryById(Integer.valueOf(inventoryid));
		return "redirect:/autoinventorycontrol/warehouses";
	}
	
	@PostMapping("/inventory/{makeid}")
	public String SaveInventory(@ModelAttribute ("carinventorydto") CarInventoryDTO cidto, @PathVariable String makeid) {
		
		cidto.setcarmakeid(Integer.valueOf(makeid));
		carInventoryServiceImpl.saveCarInventory(cidto);
		
		logger.info("^^^^^^^^^^^^^^^^^^cidto^^^^^^^^^^^"+cidto.toString());
		
		
		return "redirect:/autoinventorycontrol/warehouses";
	}
	
	@GetMapping("/inventory/new/{warehouseId}/{carmakeid}/{carmake}")
	public String createInventory(@PathVariable String warehouseId,@PathVariable String carmakeid,@PathVariable String carmake, Model model) {
		
		logger.info("&&&&&&&&&&&carmakeid###############"+carmakeid);
		List<CarMakeDTO> dtolist = new ArrayList<>();
		String warehouseLoc = "";
		
		dtolist = carMakeServiceImpl.findByWareHouseId(Integer.valueOf(warehouseId));
		
		for (CarMakeDTO dto : dtolist) {
			warehouseLoc = dto.getWarehouseLocation();
			
		}
		
		CarInventoryDTO cidto = new CarInventoryDTO();
		
		model.addAttribute("carinventorydto", cidto);
		model.addAttribute("warehouseId", warehouseId);
		model.addAttribute("warehouseLoc", warehouseLoc);
		model.addAttribute("carmake", carmake);
		model.addAttribute("makeid", carmakeid);
		
		return "createinventory";
	}
	
	@GetMapping(value="/inventory/showinventorydetails/{carmakeid}")
	public @ResponseBody List<CarInventoryDTO> getInventoryDetails(@PathVariable String carmakeid) {

		logger.info("carmakeId: " + carmakeid);

		List<CarInventoryDTO> dtolist = new ArrayList<>();

		dtolist = carInventoryServiceImpl.findCarInventoryBymakeId(Integer.valueOf(carmakeid));

		logger.info("_________________"+dtolist.toString());
		return dtolist;

	}
	
	
	
	
	
	@GetMapping("/error")
	public String fallback(Model model) {

		logger.info("Entered");
		return "error";
	}

}
