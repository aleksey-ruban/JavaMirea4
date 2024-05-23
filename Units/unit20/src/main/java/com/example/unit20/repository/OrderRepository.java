package com.example.unit20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.unit20.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
