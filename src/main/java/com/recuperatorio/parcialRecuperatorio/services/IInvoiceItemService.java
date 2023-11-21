package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.DTOS.GenreDTO;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.InvoiceItemDTO;
import com.recuperatorio.parcialRecuperatorio.models.Genre;
import com.recuperatorio.parcialRecuperatorio.models.InvoiceItem;

import java.util.List;

public interface IInvoiceItemService {
    InvoiceItem create(InvoiceItemDTO genre);

    InvoiceItem update(InvoiceItemDTO  genre);


    InvoiceItem delete(int id);

    List<InvoiceItem> getAll();

    InvoiceItem findById(int id);
}
