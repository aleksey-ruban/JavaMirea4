package com.example.unit16.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Departure {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private Integer id;
    @Getter
    private String type;
    @Getter
    private String departureDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_office_id", referencedColumnName = "id")
    private PostOffice postOffice;

    public Departure(String name, String creationDate) {
        this.type = name;
        this.departureDate = creationDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public boolean equals(Object obj) {
        return this.type.equals(((Departure) obj).getType()) &&
                this.departureDate.equals(((Departure) obj).getDepartureDate());
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
