package com.example.unit19.Service;

import com.example.unit19.Entity.Departure;

import java.util.List;

public interface DepartureService {
    void create(Departure departure);
    List<Departure> readAll();
    Departure read(Integer id);
    boolean update(Departure departure, Integer id);
    boolean delete(Integer id);
}
