package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Categoria;
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}
