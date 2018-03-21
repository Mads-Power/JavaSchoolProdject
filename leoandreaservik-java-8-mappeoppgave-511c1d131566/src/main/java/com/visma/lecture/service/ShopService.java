package com.visma.lecture.service;

import com.sun.javafx.collections.MappingChange;
import com.visma.lecture.common.domain.Item;
import com.visma.lecture.common.domain.support.ItemLocation;
import com.visma.lecture.common.domain.support.ItemType;
import com.visma.lecture.repository.ShopRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Service class for shop
 *
 * @author Leo-Andreas Ervik
 */
public class ShopService {

	private final ShopRepository shopRepository;

	public ShopService(ShopRepository shopRepository) {
		this.shopRepository = shopRepository;
	}

	public Map<ItemLocation, List<Item>> getMapPerLocation() {
		return shopRepository.getAllItems().stream().collect(Collectors.groupingBy(Item::getItemLocation));
	}

	public Map<ItemType, List<Item>> getMapPerType() {
		return shopRepository.getAllItems().stream().collect(Collectors.groupingBy(Item::getItemType));
	}

	/*public Map<String,List<Item>>getMapPerProducer(){
		return //shopRepository.ItemFoundByProducer("producer1").stream().;
	}*/
	public Map<Boolean, List<Item>> getMapItemPerUnderXAmount() {
		return shopRepository.getAllItems().stream().collect(Collectors.partitioningBy(e -> e.getStock() > 1500));
	}

	public String producersSeperatedByX(String x) {
		return shopRepository.getAllItems().stream().map(Item::getItemName).collect(Collectors.joining(x));
	}

	public List<ItemLocation> listWithMoreThanXInStock(int x) {
		//jeg har valgt å løse den sånn
		return shopRepository.getAllItems().stream().filter(e -> e.getStock() > x).map(Item::getItemLocation).collect(Collectors.toList());
	}

	public List<ItemLocation> listWithLessThanXInStock(int x) {
		//jeg har valgt å løse den sånn
		return shopRepository.getAllItems().stream().filter(e -> e.getStock() < x).map(Item::getItemLocation).collect(Collectors.toList());
	}

	public List<Item> listWithNamesStartWithX(String x) {
		return shopRepository.getAllItems().stream().filter(e -> e.getItemName().startsWith(x)).collect(Collectors.toList());
	}

	public List<Item> sortAlphabetacllyByProducer() {
		return shopRepository.getAllItems().stream().sorted(Comparator.comparing(e -> e.getTheProducer())).collect(Collectors.toList());
	}

	public List<Item> sorthAlphabetacllyByName() {
		return shopRepository.getAllItems().stream().sorted(Comparator.comparing(e -> e.getItemName())).collect(Collectors.toList());
	}
	public List<Item> sortFromHighToLow(){
		return shopRepository.getAllItems().stream().sorted(Comparator.comparing(e->e.getStock())).collect(Collectors.toList());
	}
	public List<Item>findIfduplicates(){
		return shopRepository.getAllItems().stream().sorted().distinct().collect(Collectors.toList());
	}



}