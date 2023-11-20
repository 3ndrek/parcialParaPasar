package com.recuperatorio.parcialRecuperatorio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genreid")
    private int genreId;
    @Column(name="name")
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
