package com.recuperatorio.parcialRecuperatorio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artists")
@Entity
public class Artist {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "artistid")
private int artistId;

    @Column(name = "Name")
    private String name;
}
