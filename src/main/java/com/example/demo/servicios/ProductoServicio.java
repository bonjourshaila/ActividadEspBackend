package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductoDTO;
import com.example.demo.entidades.Producto;
import com.example.demo.repositorios.ProductoRepositorio;
@Service
public class ProductoServicio {
	
	@Autowired
	private transient ProductoRepositorio productoRepositorio;
	
	
	public List<ProductoDTO> obtenerProductos(){
		List<ProductoDTO> respuesta = new ArrayList<>();
		List<Producto>productos = productoRepositorio.findAll();
		if (!productos.isEmpty()){
			productos.forEach(p -> {
				respuesta.add(new ProductoDTO(p));
			});
		}

		return respuesta;		
	}
	
	public ProductoDTO obtenerProductoById(Long id){
		ProductoDTO respuesta = new ProductoDTO();
		Optional<Producto>producto = productoRepositorio.findById(id);
		if (producto != null && producto.isPresent()) {
			respuesta = new ProductoDTO(producto.get());
		}
			
		return respuesta;		
	}
	
	public ProductoDTO crearProducto(ProductoDTO productoDTO){
		Producto producto = new Producto();
		producto.setNombreProducto(productoDTO.getNombre());
		producto.setDescripcionProducto(productoDTO.getDescripcion());
		productoRepositorio.save(producto);
		ProductoDTO respuesta = new ProductoDTO(producto);
		return respuesta;		
	}
	
	public ProductoDTO editarProducto(Long id,ProductoDTO productoDTO){
		Optional<Producto>producto = productoRepositorio.findById(id);
		ProductoDTO respuesta = new ProductoDTO();
		if (producto != null && producto.isPresent()){
			producto.get().setNombreProducto(productoDTO.getNombre());
			producto.get().setDescripcionProducto(productoDTO.getDescripcion());
			productoRepositorio.save(producto.get());
			respuesta = new ProductoDTO(producto.get());
		}
		return respuesta;		
	}
	
	public ProductoDTO eliminarProducto(Long id){
		ProductoDTO respuesta = new ProductoDTO();
		Optional<Producto>producto = productoRepositorio.findById(id);
		if (producto != null && producto.isPresent()){
			productoRepositorio.delete(producto.get());
			respuesta = new ProductoDTO(producto.get());
		}
		return respuesta;		
	}
	
	
}
