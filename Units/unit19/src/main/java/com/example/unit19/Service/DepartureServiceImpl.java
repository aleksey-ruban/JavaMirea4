package com.example.unit19.Service;

import com.example.unit19.Entity.Departure;
import com.example.unit19.Repository.DepartureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartureServiceImpl implements DepartureService {

    private final DepartureRepository repository;

    @Autowired
    public DepartureServiceImpl(DepartureRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Departure departure) {
        log.info("Create departure " + departure.getType() + " " + departure.getDepartureDate());
        repository.save(departure);
    }

    @Override
    public List<Departure> readAll() {
        log.info("Read All departures");
        return repository.findAll();
    }

    @Override
    public Departure read(Integer id) {
        log.info("Read departure with id " + id);
        return repository.getReferenceById(id);
    }

    @Override
    public boolean update(Departure departure, Integer id) {
        log.info("Update departure with id " + id);
        if (repository.existsById(id)) {
            departure.setId(id);
            repository.save(departure);
            return  true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        log.info("Delete departure with id " + id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
