package com.skillstorm.DTOs;

public class CarMakeDTO {

	private String make;
	private int makecount;
	private int makeId;
	private int warehouseId;
	private String warehouseLocation;
	
	
	
	public CarMakeDTO() {
		super();
	}
	
	
	public int getMakecount() {
		return makecount;
	}


	public void setMakecount(int makecount) {
		this.makecount = makecount;
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
		return "CarMakeDTO [make=" + make + ", makecount=" + makecount + ", makeId=" + makeId + ", warehouseId="
				+ warehouseId + ", warehouseLocation=" + warehouseLocation + "]";
	}
	

	
	
}
