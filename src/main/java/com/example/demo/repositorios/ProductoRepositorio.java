package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
