package com.learning.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.inventorymanagement.controller.dto.ItemDTO;
import com.learning.inventorymanagement.entitiy.Item;
import com.learning.inventorymanagement.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService InventoryService;
	
	@RequestMapping(value="/items", method=RequestMethod.GET, produces="application/json")
	public List<ItemDTO> getAllItems() {
		List<Item> items = InventoryService.getAllItems();
		List<ItemDTO> result = new ArrayList<>();
		for(Item item : items) {
			result.add(new ItemDTO(item.getId(), item.getName(), item.getDescription(), item.getQuantity(), item.getPrice()));
		}
		
		return result;
	}
	
	@RequestMapping(value="/item/{itemId}", method=RequestMethod.GET, produces="application/json")
	public ItemDTO getItemById(@PathVariable long itemId) {
		Optional<Item> queryResult = InventoryService.getItemById(itemId);
		Item item = queryResult.get();
		return new ItemDTO(item.getId(), item.getName(), item.getDescription(), item.getQuantity(), item.getPrice());
	}
}
