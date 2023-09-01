package com.skillstorm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.skillstorm.models.CarInventory;
import com.skillstorm.services.CarInventoryServiceImpl;
import com.skillstorm.services.CarMakeServiceImpl;
import com.skillstorm.services.WareHouseServiceImpl;

@Controller
@RequestMapping("/autoinventorycontrol")
public class AutoInventoryController {

	private WareHouseServiceImpl wareHouseServiceImpl;

	private CarMakeServiceImpl carMakeServiceImpl;

	private CarInventoryServiceImpl carInventoryServiceImpl;

	/* Auto wired the beans */
	public AutoInventoryController(WareHouseServiceImpl wareHouseServiceImpl, CarMakeServiceImpl carMakeServiceImpl,
			CarInventoryServiceImpl carInventoryServiceImpl) {
		super();
		this.wareHouseServiceImpl = wareHouseServiceImpl;
		this.carMakeServiceImpl = carMakeServiceImpl;
		this.carInventoryServiceImpl = carInventoryServiceImpl;
	}

	Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * 
	 * This end point navigates to home page
	 * 
	 */
	@GetMapping("/home")
	public String gotohome(Model model) {

		logger.info("Entered the gotohome method");

		try {

			return "home";

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * 
	 * This returns the list of warehouses
	 * 
	 */
	@GetMapping("/warehouses")
	public String getWarehouses(Model model) {

		logger.info("Entered the getWarehouses method");

		try {
			List<WareHouseResponseDTO> whdtolist = new ArrayList<>();

			whdtolist = wareHouseServiceImpl.findAll();

			model.addAttribute("warehouses", whdtolist);

			logger.debug("Warehouse list" + whdtolist.toString());

			return "warehouses";

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * This end point returns the inventory of each make(brand) of the warehouse
	 */

	@GetMapping("/inventory/{warehouseId}")
	public String getmake(@PathVariable String warehouseId, Model model) {

		logger.info("Entered the getmake method");
		try {
			logger.debug("warehouseId: " + warehouseId);

			List<CarMakeDTO> dtolist = new ArrayList<>();
			String warehouseLoc = "";

			dtolist = carMakeServiceImpl.findByWareHouseId(Integer.valueOf(warehouseId));

			for (CarMakeDTO dto : dtolist) {
				logger.debug("warehouseLoc " + warehouseLoc);
				logger.debug("dto: " + dto.toString());
				warehouseLoc = dto.getWarehouseLocation();
				warehouseId = String.valueOf(dto.getWarehouseId());
			}

			logger.debug(dtolist.toString());
			model.addAttribute("carmakelist", dtolist);
			model.addAttribute("warehouseLoc", warehouseLoc);
			model.addAttribute("warehouseId", warehouseId);

			return "carinventory";

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * This end point takes us to the form to add new inventory
	 */
	@GetMapping("/inventory/new/{warehouseId}/{carmakeid}/{carmake}")
	public String createInventory(@PathVariable String warehouseId, @PathVariable String carmakeid,
			@PathVariable String carmake, Model model) {

		logger.info("Entered the createInventory method");

		try {
			logger.debug("carmakeid" + carmakeid);
			logger.debug("warehouseId" + warehouseId);
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

	/*
	 * This end point takes us to: update the existing inventory form page
	 * 
	 */
	@GetMapping("/inventory/edit/{inventoryid}/{carmakeid}/{carmake}")
	public String editInventory(@PathVariable String inventoryid, @PathVariable String carmakeid,
			@PathVariable String carmake, Model model) {

		logger.info("Entered the editInventory method");

		try {
			model.addAttribute("carmakeid", carmakeid);
			model.addAttribute("invid", inventoryid);
			model.addAttribute("carmake", carmake);

			logger.debug("inventoryid: " + inventoryid + " carmakeid" + carmakeid);

			model.addAttribute("carinv", carInventoryServiceImpl.getCarInventory(Integer.valueOf(inventoryid)));

			return "updateinventory";

		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * This is reached once the user clicks the delete button to delete the
	 * inventory. The pertaining data is deleted in the DB and control is redirected
	 * back to inventory list page.
	 */
	@GetMapping("deleteinventory/{inventoryid}/{warehouseid}")
	public String deleteInventory(@PathVariable String inventoryid, @PathVariable String warehouseid) {

		logger.info("Entered the deleteInventory method");

		try {
			carInventoryServiceImpl.deleteCarInventoryById(Integer.valueOf(inventoryid));
			return "redirect:/autoinventorycontrol/inventory/" + warehouseid;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * This end point is called once the user clicks delete button for car make. The
	 * car make and all the car inventory pertaining to it will be deleted
	 * 
	 */

	@GetMapping("deletecarmake/{warehouseId}/{carmakeid}")
	public String deleteCarMake(@PathVariable String warehouseId, @PathVariable String carmakeid) {

		logger.info("Entered the deleteInventory method");

		try {

			carMakeServiceImpl.deleteCarMakeById(Integer.valueOf(carmakeid));
			return "redirect:/autoinventorycontrol/inventory/" + warehouseId;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * Method is called within javascript ajax to populate the inventory details of
	 * a particular brand(make)
	 */
	@GetMapping(value = "/inventory/showinventorydetails/{carmakeid}")
	public @ResponseBody List<CarInventoryDTO> getInventoryDetails(@PathVariable String carmakeid) {

		logger.info("Entered the getInventoryDetails method");

		try {
			logger.debug("carmakeId: " + carmakeid);

			List<CarInventoryDTO> dtolist = new ArrayList<>();

			dtolist = carInventoryServiceImpl.findCarInventoryBymakeId(Integer.valueOf(carmakeid));

			logger.debug("dtolist" + dtolist.toString());
			return dtolist;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	/*
	 * This adds new inventory to the DB and redirects to inventory details page.
	 */
	@PostMapping("/inventory/{makeid}")
	public String addInventory(@ModelAttribute("carinventorydto") CarInventoryDTO cidto, @PathVariable String makeid) {
		logger.info("Entered the saveInventory method");

		try {

			if (!(makeid == null))
				cidto.setcarmakeid(Integer.valueOf(makeid));
			int warehouseid = carInventoryServiceImpl.saveCarInventory(cidto);

			logger.debug("cidto: " + cidto.toString());

			return "redirect:/autoinventorycontrol/inventory/" + warehouseid;
		}

		catch (Exception e) {
			return "error";
		}
	}

	/*
	 * Method updates the existing inventory and saves the updated details in the DB
	 * and redirects to the inventory page.
	 */
	@PostMapping("updateinventory/{inventoryid}/{carmakeid}")
	public String updateInventory(@ModelAttribute("carinv") CarInventory ci, @PathVariable String inventoryid,
			@PathVariable String carmakeid) {

		logger.info("Entered the updateInventory method");
		try {

			int warehouseid = carInventoryServiceImpl.updateCarInventory(ci, inventoryid, carmakeid);
			return "redirect:/autoinventorycontrol/inventory/" + warehouseid;
		}

		catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return "error";
		}
	}

	/*
	 * Method adds new car make to the DB
	 */
	@GetMapping("/inventory/newmake/{warehouseid}/{newmake}")
	public String addNewMake(
			// @ModelAttribute("carmakedto") CarMakeDTO cmdto,
			@PathVariable String warehouseid, @PathVariable String newmake) {
		logger.info("Entered the saveInventory method");

		try {

			if (!(warehouseid == null))
				carMakeServiceImpl.saveNewCarMake(Integer.valueOf(warehouseid), newmake);

			return "redirect:/autoinventorycontrol/inventory/" + warehouseid;
		}

		catch (Exception e) {
			return "error";
		}
	}

	/*
	 * In case of any exceptions or errors, the user will be redirected to the error
	 * page
	 */
	@GetMapping("/error")
	public String fallback(Model model) {

		logger.info("Entered the fallback");
		return "error";
	}

}
