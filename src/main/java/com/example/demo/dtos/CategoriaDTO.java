package com.example.demo.dtos;

import com.example.demo.entidades.Categoria;

public class CategoriaDTO {
	
	private Integer idCategoria;
	private String nombre;
	private String descripcion;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria c) {
		this.idCategoria = c.getIdCategoria();
		this.nombre = c.getNombreCategoria();
		this.descripcion = c.getDescripcionCategoria();
    }

    public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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
