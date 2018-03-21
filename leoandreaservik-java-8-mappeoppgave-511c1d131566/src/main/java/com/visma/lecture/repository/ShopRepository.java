package com.visma.lecture.repository;

import com.visma.lecture.common.domain.Item;
import com.visma.lecture.common.domain.support.ItemLocation;
import com.visma.lecture.common.domain.support.ItemType;
import com.visma.lecture.service.ShopService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Repository class for shop
 *
 * @author Leo-Andreas Ervik
 */
public class ShopRepository {

	private final List<Item> items;

	public ShopRepository(List<Item> items) {
		this.items = items;
	}

	public Item findItemById(Integer id) {
		return items.stream()
				.filter(e -> e.getItemID().equals(id))
				.findFirst()
				.orElse(null);
	}
	public List<Item> getFoundItemById(Integer low, Integer high){
		return items.stream()
				.filter(e -> e.getItemID() > low && e.getItemID()< high)
				.collect(Collectors.toList());
	}

	public Boolean create(Item item) {
		return items.add(item);
	}

	public Boolean update(Item item) {
		Item i = findItemById(item.getItemID());
		delete(i.getItemID());
		return create(item);
	}
	public List<Item> ItemFoundPerLocation(ItemLocation location){
		return items.stream().filter(e ->e.getItemLocation().equals(location)).collect(Collectors.toList());
	}

	public List<Item> ItemFoundPerType(ItemType itemtype){
		return items.stream().filter(e ->e.getItemType().equals(itemtype)).collect(Collectors.toList());
	}
	public List<Item> ItemFoundByProducer(String producer){
		return items.stream().filter(e ->e.getItemName().
				startsWith("producer1")).collect(Collectors.toList());
	}

	public Boolean delete(Integer itemId) {
		return items.removeIf(e -> e.getItemID().equals(itemId));
	}

	public List<Item> getAllItems() {
		return items;
	}



}
