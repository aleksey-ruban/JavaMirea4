package com.example.unit18.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departure {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemsIdSeq")
    private Integer id;
    @Getter
    private String type;
    @Getter
    @Column(name = "departure_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private LocalDateTime departureDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_office_id", referencedColumnName = "id")
    private PostOffice postOffice;

    public Departure(String name, LocalDateTime departureDate) {
        this.type = name;
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
