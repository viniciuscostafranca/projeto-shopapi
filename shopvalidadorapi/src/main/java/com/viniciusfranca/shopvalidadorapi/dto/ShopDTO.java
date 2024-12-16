package com.viniciusfranca.shopvalidadorapi.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopDTO {
	private String identifier;
	private LocalDate dateShop;
	private String status;
	private List<ShopItemDTO> items = new ArrayList<>();

	
}
