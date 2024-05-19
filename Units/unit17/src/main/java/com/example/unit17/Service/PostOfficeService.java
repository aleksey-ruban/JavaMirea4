package com.example.unit17.Service;

import com.example.unit17.Entity.PostOffice;

import java.util.List;

public interface PostOfficeService {
    void create(PostOffice postOffice);
    List<PostOffice> readAll();
    PostOffice read(Integer id);
    boolean update(PostOffice postOffice, Integer id);
    boolean delete(Integer id);
}
