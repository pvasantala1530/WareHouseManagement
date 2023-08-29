package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skillstorm.DTOs.CarInventoryDTO;
import com.skillstorm.DTOs.CarMakeDTO;
import com.skillstorm.DTOs.WareHouseResponseDTO;
import com.skillstorm.models.CarInventory;
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

	Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping("/warehouses")
	public String getWarehouses(Model model) {

		try {
			List<WareHouseResponseDTO> whdtolist = new ArrayList<>();

			whdtolist = wareHouseServiceImpl.findAll();

			model.addAttribute("warehouses", whdtolist);

			logger.info("hello" + whdtolist.toString());
			return "warehouses";
		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/inventory/{warehouseId}")
	public String getmake(@PathVariable String warehouseId, Model model) {

		try {
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
		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/inventory/edit/{inventoryid}/{carmakeid}") // {color}/{price}/{quantity}/{model}")
	public String editInventory(@PathVariable String inventoryid, @PathVariable String carmakeid, Model model) {// ,@PathVariable
																												// String
																												// color,@PathVariable
																												// String
																												// model,@PathVariable
																												// int
																												// quantity,
		// athVariable int price,@PathVariable int carmakeid,Model model1) {

		try {
			model.addAttribute("carmakeid", carmakeid);
			model.addAttribute("invid", inventoryid);

			logger.info("(((((((((((((((((((()))))))))))))" + inventoryid + "------" + carmakeid);

			model.addAttribute("carinv", carInventoryServiceImpl.getCarInventory(Integer.valueOf(inventoryid)));

			return "updateinventory";
		} catch (Exception e) {
			return "error";
		}
	}

	@PostMapping("updateinventory/{inventoryid}/{carmakeid}")
	public String updateInventory(@ModelAttribute("carinv") CarInventory ci, @PathVariable String inventoryid,
			@PathVariable String carmakeid) {

		try {
			int warehouseid = carInventoryServiceImpl.updateCarInventory(ci, inventoryid, carmakeid);
			return "redirect:/autoinventorycontrol/inventory/"+warehouseid;
		} 
		
		catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("deleteinventory/{inventoryid}")
	public String deleteInventory(@PathVariable String inventoryid) {
		try {
			carInventoryServiceImpl.deleteCarInventoryById(Integer.valueOf(inventoryid));
			return "redirect:/autoinventorycontrol/warehouses";
		} catch (Exception e) {
			return "error";
		}
	}

	// @PostMapping("/inventory/{warehouseId}/{makeid}/{carmake}")
	@PostMapping("/inventory/{makeid}")
	public String SaveInventory(@Valid CarInventory validateCarInv, BindingResult result,
			@ModelAttribute("carinventorydto") CarInventoryDTO cidto,
			// @PathVariable String warehouseId,
			@PathVariable String makeid
	// @PathVariable String carmake
	) {

		try {
			cidto.setcarmakeid(Integer.valueOf(makeid));
			int warehouseid = carInventoryServiceImpl.saveCarInventory(cidto);

			logger.info("^^^^^^^^^^^^^^^^^^cidto^^^^^^^^^^^" + cidto.toString());

			return "redirect:/autoinventorycontrol/inventory/"+warehouseid;
		} 
		
		catch (Exception e) {
			return "error";
		}
	}

	@GetMapping("/inventory/new/{warehouseId}/{carmakeid}/{carmake}")
	public String createInventory(@PathVariable String warehouseId, @PathVariable String carmakeid,
			@PathVariable String carmake, Model model) {

		try {
			logger.info("&&&&&&&&&&&carmakeid###############" + carmakeid);
			logger.info("&&&&&&&&&&&warehouseId###############" + warehouseId);
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
		} catch (Exception e) {
			return "error";
		}
	}

	@GetMapping(value = "/inventory/showinventorydetails/{carmakeid}")
	public @ResponseBody List<CarInventoryDTO> getInventoryDetails(@PathVariable String carmakeid) {
		try {
			logger.info("carmakeId: " + carmakeid);

			List<CarInventoryDTO> dtolist = new ArrayList<>();

			dtolist = carInventoryServiceImpl.findCarInventoryBymakeId(Integer.valueOf(carmakeid));

			logger.info("_________________" + dtolist.toString());
			return dtolist;
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/error")
	public String fallback(Model model) {

		logger.info("Entered");
		return "error";
	}

}
