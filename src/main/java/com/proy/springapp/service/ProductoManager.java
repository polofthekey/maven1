package com.proy.springapp.service;

import java.io.Serializable;
import java.util.List;

import com.proy.springapp.domain.Producto;

public interface ProductoManager extends Serializable{
	
	public void incrementarPrecio(int porcentaje);
	
	public List<Producto> getProductos();
}
