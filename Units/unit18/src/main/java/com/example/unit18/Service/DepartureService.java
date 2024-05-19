package com.example.unit18.Service;

import com.example.unit18.Entity.Departure;

import java.util.List;

public interface DepartureService {
    void create(Departure departure);
    List<Departure> readAll();
    Departure read(int id);
    boolean update(Departure departure, int id);
    boolean delete(int id);
}
