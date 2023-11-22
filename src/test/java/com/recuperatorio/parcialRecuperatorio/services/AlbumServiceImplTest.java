package com.recuperatorio.parcialRecuperatorio.services;

import com.recuperatorio.parcialRecuperatorio.models.Album;
import com.recuperatorio.parcialRecuperatorio.models.DTOS.AlbumDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application.properties")
@SpringBootTest
class AlbumServiceImplTest {
    @Autowired
    private IAlbumService albumService;

    @Test
    void create() {
        AlbumDTO nuevoAlbum = new AlbumDTO();
        nuevoAlbum.setTitle("Album de prueba");
        nuevoAlbum.setArtist(1);
        Album albumCreado = albumService.create(nuevoAlbum);
        // me fijo si existe el nuevo album
        Album AlbumParaTestear = albumService.findById(albumCreado.getAlbumId());
        // lo borramos de la base de datos
        albumService.delete(AlbumParaTestear.getAlbumId());
        assertEquals(AlbumParaTestear.getTitle(),nuevoAlbum.getTitle());
    }

    @Test
    void update() {
        AlbumDTO nuevoAlbum = new AlbumDTO();
        nuevoAlbum.setTitle("Album de prueba");
        nuevoAlbum.setArtist(1);
        Album albumCreado = albumService.create(nuevoAlbum);
        // cambio el titulo
        nuevoAlbum.setAlbumid(albumCreado.getAlbumId());
        nuevoAlbum.setTitle("Album de prueba 2");
        // lo actualizo
        Album AlbumParaTestear = albumService.update(nuevoAlbum);
        // lo borro de la base de datos
        albumService.delete(AlbumParaTestear.getAlbumId());
        // me fijo si el titulo cambio
        assertNotEquals(AlbumParaTestear.getTitle(), albumCreado.getTitle());
    }
    @Test
    void update2() {
        AlbumDTO nuevoAlbum = new AlbumDTO();
        nuevoAlbum.setTitle("Album de prueba");
        nuevoAlbum.setArtist(1);
        Album albumCreado = albumService.create(nuevoAlbum);
        // cambio el titulo
        nuevoAlbum.setAlbumid(albumCreado.getAlbumId());
        nuevoAlbum.setTitle("Album de prueba 2");
        // lo actualizo
        Album AlbumParaTestear = albumService.update(nuevoAlbum);
        // lo borro de la base de datos
        albumService.delete(AlbumParaTestear.getAlbumId());
        // me fijo si el id sigue siendo el mismo en ambos casos
        assertEquals(AlbumParaTestear.getAlbumId(), albumCreado.getAlbumId());
    }

    @Test
    void delete() {
        // creamos un album
        AlbumDTO nuevoAlbum = new AlbumDTO();
        nuevoAlbum.setTitle("Album de prueba");
        nuevoAlbum.setArtist(1);
        Album albumCreado = albumService.create(nuevoAlbum);
        // me fijo si existe el nuevo album
        Album AlbumParaTestear = albumService.findById(albumCreado.getAlbumId());
        // lo borramos de la base de datos
        albumService.delete(AlbumParaTestear.getAlbumId());
        // me fijo si existe el nuevo album
        Optional<Album> AlbumParaTestear2;
        try {
            AlbumParaTestear2 = Optional.ofNullable(albumService.findById(albumCreado.getAlbumId()));
        } catch (Exception e) {
            AlbumParaTestear2 = null;
        }
        assertNull(AlbumParaTestear2);
    }


    @Test
    void findById() {
        AlbumDTO nuevoAlbum = new AlbumDTO();
        nuevoAlbum.setTitle("Album de prueba");
        nuevoAlbum.setArtist(1);
        Album albumCreado = albumService.create(nuevoAlbum);
        Album AlbumParaTestear = albumService.findById(albumCreado.getAlbumId());
        // lo borramos de la base de datos
        albumService.delete(AlbumParaTestear.getAlbumId());
        assertEquals(AlbumParaTestear.getTitle(),nuevoAlbum.getTitle());

    }
}