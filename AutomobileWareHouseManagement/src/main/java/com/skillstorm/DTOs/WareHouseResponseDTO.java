package com.skillstorm.DTOs;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

public class WareHouseResponseDTO {

		private int id;
		private String location;
		
		
		/*
		 * public WareHouseResponseDTO(int id, String location) { super(); this.id = id;
		 * this.location = location; }
		 */
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		@Override
		public String toString() {
			return "WareHouseResponseDTO [id=" + id + ", location=" + location + "]";
		}
	
	
}
