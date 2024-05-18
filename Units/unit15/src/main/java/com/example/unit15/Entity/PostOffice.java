package com.example.unit15.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private Integer id;
    private String name;
    private String cityName;

    public PostOffice(String name, String creationDate) {
        this.name = name;
        this.cityName = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((PostOffice) obj).getName()) &&
                this.cityName.equals(((PostOffice) obj).getCityName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
