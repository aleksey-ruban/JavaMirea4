package com.example.unit15.Service;

import com.example.unit15.Entity.PostOffice;

import java.util.List;

public interface PostOfficeService {
    void create(PostOffice postOffice);
    List<PostOffice> readAll();
    PostOffice read(int id);
    boolean update(PostOffice postOffice, int id);
    boolean delete(int id);
}
