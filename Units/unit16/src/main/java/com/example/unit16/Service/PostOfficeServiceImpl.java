package com.example.unit16.Service;

import com.example.unit16.Entity.PostOffice;
import com.example.unit16.Repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {
    private final PostOfficeRepository repository;

    @Autowired
    public PostOfficeServiceImpl(PostOfficeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PostOffice postOffice) {
        repository.save(postOffice);
    }

    @Override
    public List<PostOffice> readAll() {
        return repository.findAll();
    }

    @Override
    public PostOffice read(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public boolean update(PostOffice postOffice, int id) {
        if (repository.existsById(id)) {
            postOffice.setId(id);
            repository.save(postOffice);
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
