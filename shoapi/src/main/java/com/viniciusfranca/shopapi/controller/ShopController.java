package com.viniciusfranca.shopapi.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusfranca.shopapi.dto.ShopDTO;
import com.viniciusfranca.shopapi.events.KafkaClient;
import com.viniciusfranca.shopapi.model.Shop;
import com.viniciusfranca.shopapi.model.ShopItem;
import com.viniciusfranca.shopapi.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
	private final ShopRepository shopRepository;
	private final KafkaClient kafkaClient;

	@GetMapping
	public List<ShopDTO> getShop() {
		return shopRepository.findAll().stream().map(shop -> ShopDTO.convert(shop)).collect(Collectors.toList());
	}

	@PostMapping
	public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {

		shopDTO.setIdentifier(UUID.randomUUID().toString());
		shopDTO.setDateShop(LocalDate.now());
		shopDTO.setStatus("PENDING");
		Shop shop = Shop.convert(shopDTO);
		for (ShopItem shopItem : shop.getItems()) {
			shopItem.setShop(shop);
		}
		shopDTO = ShopDTO.convert(shopRepository.save(shop));
		kafkaClient.sendMessage(shopDTO);
		return shopDTO;
	}
}