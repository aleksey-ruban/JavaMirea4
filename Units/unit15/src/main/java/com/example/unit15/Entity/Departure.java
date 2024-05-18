package com.example.unit15.Entity;

import jakarta.persistence.*;

@Entity
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private Integer id;
    private String type;
    private String departureDate;

    public Departure(String name, String creationDate) {
        this.type = name;
        this.departureDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.type.equals(((Departure) obj).getType()) &&
                this.departureDate.equals(((Departure) obj).getDepartureDate());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
