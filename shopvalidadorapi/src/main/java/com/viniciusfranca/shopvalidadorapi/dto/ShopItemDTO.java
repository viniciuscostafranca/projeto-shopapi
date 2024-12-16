package com.viniciusfranca.shopvalidadorapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShopItemDTO {
	private String productIdentifier;
	private Integer amount;
	private Float price;


}
