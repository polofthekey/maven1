package com.proy.springapp.service;

import java.util.List;

import com.proy.springapp.domain.Producto;

public class SimpleProductoManager implements ProductoManager{

	private static final long serialVersionUID = 1L;

	private List<Producto> productos;
	
	public SimpleProductoManager() {
		// TODO Auto-generated constructor stub
	}

	public void incrementarPrecio(int porcentaje) {
		//throw new UnsupportedOperationException();
		if (productos != null){
			for (Producto producto : productos){
				double nuevoPrecio = producto.getPrecio().doubleValue() * (100 + porcentaje)/100;
				producto.setPrecio(nuevoPrecio);
			}
		}
	}

	public List<Producto> getProductos() {
		//throw new UnsupportedOperationException();
		return productos;
	}
	
	public void setProductos(List<Producto> productos){
		//throw new UnsupportedOperationException();
		this.productos = productos;
	}

}
