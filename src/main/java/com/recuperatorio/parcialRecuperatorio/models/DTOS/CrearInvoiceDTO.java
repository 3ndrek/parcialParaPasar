package com.recuperatorio.parcialRecuperatorio.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrearInvoiceDTO {

// id de cliente, id de artista y montoMáximo

 private int idCliente;

 private int idArtista;

 private double montoMaximo;
}
