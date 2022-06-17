package com.example.demo.controladores;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductoDTO;
import com.example.demo.servicios.ProductoServicio;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
	@Autowired
	private transient ProductoServicio productoServicio;

	@ApiOperation(value = "Servicio que obtiene todo el listado de productos")
	@GetMapping("")
	public List<ProductoDTO> listarProductos(){
		return productoServicio.obtenerProductos();
	}

	@ApiOperation(value = "Servicio que obtiene el producto con el id recibido")
	@GetMapping("/{id}")
	public ProductoDTO listarProductoById(@PathVariable Long id){
		return productoServicio.obtenerProductoById(id);
	}

	@ApiOperation(value = "Servicio que guarda un producto")
	@PostMapping("")
	public ProductoDTO crearProducto(@RequestBody ProductoDTO producto){
		return productoServicio.crearProducto(producto);
	}


	@ApiOperation(value = "Servicio que edita un producto de acuerdo al id recibido")
	@PutMapping("/{id}")
	public ProductoDTO editarProducto(@PathVariable Long id, @RequestBody ProductoDTO producto){
		return productoServicio.editarProducto(id, producto);
	}

	@ApiOperation(value = "Servicio que elimina el producto con el id recibido")
	@DeleteMapping("/{id}")
	public ProductoDTO eliminarProductoById(@PathVariable Long id){
		return productoServicio.eliminarProducto(id);
	}

}
