package com.example.unit20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.unit20.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
