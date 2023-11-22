package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Artist;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.ArtistDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
class ArtistServiceImplTest {
    @Autowired
    private IArtistService artistService;
    @Test
    void create() {
        ArtistDTO nuevoArtist = new ArtistDTO();
        nuevoArtist.setName("Artista de prueba");
        Artist artistCreado = artistService.create(nuevoArtist);
        // me fijo si existe el nuevo artista
        Artist artistParaTestear = artistService.findById(artistCreado.getArtistId());
        // lo borramos de la base de datos
        artistService.delete(artistParaTestear.getArtistId());
        assertEquals(artistParaTestear.getName(),nuevoArtist.getName());
    }

    @Test
    void update() {
        ArtistDTO nuevoArtist = new ArtistDTO();
        nuevoArtist.setName("Artista de prueba");
        Artist artistCreado = artistService.create(nuevoArtist);
        // cambio el nombre
        nuevoArtist.setId(artistCreado.getArtistId());
        nuevoArtist.setName("Artista de prueba 2");
        // lo actualizo
        Artist artistParaTestear = artistService.update(nuevoArtist);
        // lo borro de la base de datos
        artistService.delete(artistParaTestear.getArtistId());
        // me fijo si el nombre cambio
        assertNotEquals(artistParaTestear.getName(), artistCreado.getName());
    }
    @Test
    void update2() {
        ArtistDTO nuevoArtist = new ArtistDTO();
        nuevoArtist.setName("Artista de prueba");
        Artist artistCreado = artistService.create(nuevoArtist);
        // cambio el nombre
        nuevoArtist.setId(artistCreado.getArtistId());
        nuevoArtist.setName("Artista de prueba 2");
        // lo actualizo
        Artist artistParaTestear = artistService.update(nuevoArtist);
        // lo borro de la base de datos
        artistService.delete(artistParaTestear.getArtistId());
        // me fijo si el id sigue siendo el mismo en ambos casos
        assertEquals(artistParaTestear.getArtistId(), artistCreado.getArtistId());
    }
    @Test
    void delete() {
        ArtistDTO nuevoArtist = new ArtistDTO();
        nuevoArtist.setName("Artista de prueba");
        Artist artistCreado = artistService.create(nuevoArtist);
        // me fijo si existe el nuevo artista
        Artist artistParaTestear = artistService.findById(artistCreado.getArtistId());
        // lo borramos de la base de datos
        artistService.delete(artistParaTestear.getArtistId());
        // me fijo si existe el nuevo artista de nuevo
        assertThrows(IllegalArgumentException.class, () -> {
            artistService.findById(artistParaTestear.getArtistId());
        });
    }

    @Test
    void findById() {
        ArtistDTO nuevoArtist = new ArtistDTO();
        nuevoArtist.setName("Artista de prueba");
        Artist artistCreado = artistService.create(nuevoArtist);
        // me fijo si existe el nuevo artista
        Artist artistParaTestear = artistService.findById(artistCreado.getArtistId());
        // lo borramos de la base de datos
        artistService.delete(artistParaTestear.getArtistId());
        // me fijo si encontre el correcto
        assertEquals(artistParaTestear.getName() ,nuevoArtist.getName());
    }
}