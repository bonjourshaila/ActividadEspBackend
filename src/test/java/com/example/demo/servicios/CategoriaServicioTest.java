package com.example.demo.servicios;

import com.example.demo.dtos.CategoriaDTO;
import com.example.demo.dtos.ProductoDTO;
import com.example.demo.repositorios.CategoriaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoriaServicioTest {

    @Mock
    private transient CategoriaRepositorio categoriaRepositorio;

    @InjectMocks
    private CategoriaServicio categoriaServicio;

    private CategoriaDTO categoriaDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre("Frutas y verduras");
        categoriaDTO.setDescripcion("Sección de frutas y verduras...");
    }

    @Test
    void obtenerCategorias() {
        when(categoriaServicio.obtenerCategorias()).thenReturn(new ArrayList<>());
        assertNotNull(categoriaServicio.obtenerCategorias());
    }

    @Test
    void obtenerCategoriaById() {
        assertNotNull(categoriaServicio.obtenerCategoriaById(2));
    }

    @Test
    void crearCategoria() {
        when(categoriaServicio.crearCategoria(categoriaDTO)).thenReturn(new CategoriaDTO());
        assertNotNull(categoriaServicio.crearCategoria(categoriaDTO));
    }

    @Test
    void editarCategoria() {
        assertNotNull(categoriaServicio.editarCategoria(4, categoriaDTO));

    }

    @Test
    void eliminarCategoria() {
        assertNotNull(categoriaServicio.eliminarCategoria(2));
    }
}