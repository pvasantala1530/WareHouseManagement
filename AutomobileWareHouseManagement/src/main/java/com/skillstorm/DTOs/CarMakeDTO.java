package com.skillstorm.DTOs;

public class CarMakeDTO {

	private String make;
	private int makeId;
	private int warehouseId;
	private String warehouseLocation;
	
	
	
	public CarMakeDTO() {
		super();
	}
	
	
	public int getMakeId() {
		return makeId;
	}


	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}


	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	@Override
	public String toString() {
		return "CarMakeDTO [make=" + make +"makeid= "+makeId+ ", warehouseId=" + warehouseId + ", warehouseLocation=" + warehouseLocation
				+ "]";
	}

	
	
}
