package com.viniciusfranca.shopvalidadorapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusfranca.shopvalidadorapi.events.KafkaClient;
import com.viniciusfranca.shopvalidadorapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
	private final ProductRepository shopRepository;
	private final KafkaClient kafkaClient;


}