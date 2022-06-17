package com.example.demo.servicios;

import com.example.demo.dtos.CategoriaDTO;
import com.example.demo.entidades.Categoria;
import com.example.demo.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    private transient CategoriaRepositorio categoriaRepositorio;

    public List<CategoriaDTO> obtenerCategorias(){
        List<CategoriaDTO> respuesta = new ArrayList<>();
        List<Categoria>categorias = categoriaRepositorio.findAll();
        if (!categorias.isEmpty()){
            categorias.forEach(c -> {
                respuesta.add(new CategoriaDTO(c));
            });
        }
        return respuesta;
    }

    public CategoriaDTO obtenerCategoriaById(Integer id){
        CategoriaDTO respuesta = new CategoriaDTO();
        Optional<Categoria> categoria = categoriaRepositorio.findById(id);
        if (categoria!=null && categoria.isPresent()) {
            respuesta = new CategoriaDTO(categoria.get());
        }

        return respuesta;
    }

    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(categoriaDTO.getNombre());
        categoria.setDescripcionCategoria(categoriaDTO.getDescripcion());
        categoriaRepositorio.save(categoria);
        CategoriaDTO respuesta = new CategoriaDTO(categoria);
        return respuesta;
    }

    public CategoriaDTO editarCategoria(Integer id,CategoriaDTO categoriaDTO){
        CategoriaDTO respuesta = new CategoriaDTO();
        Optional<Categoria>categoria = categoriaRepositorio.findById(id);

        if (categoria != null && categoria.isPresent()){
            categoria.get().setNombreCategoria(categoriaDTO.getNombre());
            categoria.get().setDescripcionCategoria(categoriaDTO.getDescripcion());
            categoriaRepositorio.save(categoria.get());
            respuesta = new CategoriaDTO(categoria.get());
        }
        return respuesta;
    }

    public CategoriaDTO eliminarCategoria(Integer id){
        CategoriaDTO respuesta = new CategoriaDTO();
        Optional<Categoria>categoria = categoriaRepositorio.findById(id);
        if (categoria != null && categoria.isPresent()){
            categoriaRepositorio.delete(categoria.get());
            respuesta = new CategoriaDTO(categoria.get());
        }
        return respuesta;
    }
}
