package com.learning.inventorymanagement.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.inventorymanagement.controller.dto.ItemDTO;
import com.learning.inventorymanagement.entitiy.Item;
import com.learning.inventorymanagement.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value = "/item/addItem", method = RequestMethod.PUT, produces = "application/json")
	public void addItem(@RequestBody ItemDTO item) {
		inventoryService.addItem(modelMapper.map(item, Item.class));
	}
	
	@RequestMapping(value="/items", method=RequestMethod.GET, produces="application/json")
	public List<ItemDTO> getAllItems() {
		List<Item> items = inventoryService.getAllItems();
		return items.stream().map(item -> modelMapper.map(item, ItemDTO.class)).collect(Collectors.toList());
	}
	
	@RequestMapping(value="/item/{itemId}", method=RequestMethod.GET, produces="application/json")
	public ItemDTO getItemById(@PathVariable long itemId) {
		return modelMapper.map(inventoryService.getItemById(itemId).get(), ItemDTO.class);
	}
	
	@RequestMapping(value = "/item/updateItem/{itemId}", method = RequestMethod.POST, produces = "application/json")
	public void updateItemById(@PathVariable long itemId, @RequestParam int itemPrice) {
		inventoryService.updateItemPrice(itemId, itemPrice);
	}
	
	@RequestMapping(value = "/item/deleteItem/{itemId}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteItem(@PathVariable long itemId) {
		inventoryService.deleteItem(itemId);
	}
}
