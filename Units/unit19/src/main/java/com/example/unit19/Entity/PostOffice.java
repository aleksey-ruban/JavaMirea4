package com.example.unit19.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PostOffice {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private Integer id;
    @Getter
    private String name;
    @Getter
    private String cityName;

    public PostOffice(String name, String creationDate) {
        this.name = name;
        this.cityName = creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @OneToMany(mappedBy = "postOffice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Departure> departures;

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((PostOffice) obj).getName()) &&
                this.cityName.equals(((PostOffice) obj).getCityName());
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
