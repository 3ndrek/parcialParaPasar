package com.recuperatorio.parcialRecuperatorio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "media_types")
@NoArgsConstructor
@AllArgsConstructor
public class MediaType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="mediatypeid")
    private int mediaTypeId;
    @Column(name="name")
    private String name;

}
