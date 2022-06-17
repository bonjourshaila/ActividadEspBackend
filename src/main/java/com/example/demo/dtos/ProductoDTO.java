package com.example.demo.dtos;

import com.example.demo.entidades.Producto;

public class ProductoDTO {
	
	private Long idProducto;
	private String nombre;
	private String descripcion;
	
	
	
	
	public ProductoDTO() {
		super();
	}

	public ProductoDTO(Producto p) {
		this.idProducto = p.getIdProducto();
		this.nombre = p.getNombreProducto();
		this.descripcion = p.getDescripcionProducto();
	}
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
