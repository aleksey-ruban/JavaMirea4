package com.example.unit19.Service;

import com.example.unit19.Entity.PostOffice;
import com.example.unit19.Repository.PostOfficeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostOfficeServiceImpl implements PostOfficeService {
    private final PostOfficeRepository repository;

    @Autowired
    public PostOfficeServiceImpl(PostOfficeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(PostOffice postOffice) {
        log.info("Create postOffice " + postOffice.getName() + " " + postOffice.getCityName());
        repository.save(new PostOffice(postOffice.getName(), postOffice.getCityName()));
    }

    @Override
    public List<PostOffice> readAll() {
        log.info("Read All postOffices");
        return repository.findAll();
    }

    @Override
    public PostOffice read(Integer id) {
        log.info("Read postOffice with id " + id);
        return repository.getReferenceById(id);
    }

    @Override
    public boolean update(PostOffice postOffice, Integer id) {
        log.info("Update postOffice with id " + id);
        if (repository.existsById(id)) {
            postOffice.setId(id);
            repository.save(postOffice);
            return  true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        log.info("Delete postOffice with id " + id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
