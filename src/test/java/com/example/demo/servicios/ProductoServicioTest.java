package com.example.demo.servicios;

import com.example.demo.dtos.ProductoDTO;
import com.example.demo.repositorios.ProductoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductoServicioTest {

    @Mock
    private transient ProductoRepositorio productoRepositorio;

    @InjectMocks
    private ProductoServicio productoServicio;

    private ProductoDTO productoDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        productoDTO = new ProductoDTO();
        productoDTO.setNombre("Sabritas Adobadas");
        productoDTO.setDescripcion("50g");
    }

    @Test
    void obtenerProductos() {
        when(productoServicio.obtenerProductos()).thenReturn(new ArrayList<>());
        assertNotNull(productoServicio.obtenerProductos());
    }

    @Test
    void obtenerProductoById() {
        assertNotNull(productoServicio.obtenerProductoById(2l));
    }

    @Test
    void crearProducto() {
        when(productoServicio.crearProducto(productoDTO)).thenReturn(new ProductoDTO());
        assertNotNull(productoServicio.crearProducto(productoDTO));
    }

    @Test
    void editarProducto() {
        assertNotNull(productoServicio.editarProducto(4l, productoDTO));
    }

    @Test
    void eliminarProducto() {
        assertNotNull(productoServicio.eliminarProducto(2l));
    }
}