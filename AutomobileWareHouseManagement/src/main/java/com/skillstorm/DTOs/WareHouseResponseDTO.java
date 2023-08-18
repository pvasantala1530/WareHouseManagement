package com.skillstorm.DTOs;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter 
@Setter
public class WareHouseResponseDTO {

	private int id;
	private String location;
	
	
}
