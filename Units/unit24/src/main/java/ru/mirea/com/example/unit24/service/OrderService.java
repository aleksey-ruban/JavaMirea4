package ru.mirea.com.example.unit24.service;

import ru.mirea.com.example.unit24.model.Order;

import java.util.List;

public interface OrderService {
    void create(Order order);
    List<Order> readAll();
    Order read(int id);
    boolean update(Order order, int id);
    boolean delete(int id);
}
