package com.example.unit16.Service;

import com.example.unit16.Entity.Departure;
import com.example.unit16.Repository.DepartureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureServiceImpl implements DepartureService {

    private final DepartureRepository repository;

    @Autowired
    public DepartureServiceImpl(DepartureRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Departure departure) {
        repository.save(departure);
    }

    @Override
    public List<Departure> readAll() {
        return repository.findAll();
    }

    @Override
    public Departure read(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public boolean update(Departure departure, int id) {
        if (repository.existsById(id)) {
            departure.setId(id);
            repository.save(departure);
            return  true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
