package com.example.demo.controladores;
import com.example.demo.dtos.CategoriaDTO;
import com.example.demo.servicios.CategoriaServicio;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    @Autowired
    private transient CategoriaServicio categoriaServicio;

    @ApiOperation(value = "Servicio que obtiene todo el listado de categorias")
    @GetMapping("")
    public List<CategoriaDTO> listarCategorias(){
        return categoriaServicio.obtenerCategorias();
    }

    @ApiOperation(value = "Servicio que obtiene la categoria con el id recibido")
    @GetMapping("/{id}")
    public CategoriaDTO listarCategoriaById(@PathVariable Integer id){
        return categoriaServicio.obtenerCategoriaById(id);
    }

    @ApiOperation(value = "Servicio que guarda una categoria")
    @PostMapping("")
    public CategoriaDTO crearCategoria(@RequestBody CategoriaDTO producto){
        return categoriaServicio.crearCategoria(producto);
    }

    @ApiOperation(value = "Servicio que edita una categoria de acuerdo al id recibido")
    @PutMapping("/{id}")
    public CategoriaDTO editarCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO producto){
        return categoriaServicio.editarCategoria(id, producto);
    }

    @ApiOperation(value = "Servicio que elimina la categoria con el id recibido")
    @DeleteMapping("/{id}")
    public CategoriaDTO eliminarCategoriaById(@PathVariable Integer id){
        return categoriaServicio.eliminarCategoria(id);
    }
}
