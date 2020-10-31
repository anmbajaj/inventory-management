package com.learning.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.inventorymanagement.entitiy.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
}
