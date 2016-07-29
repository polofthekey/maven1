package com.proy.springapp.repository;

import java.util.List;

import com.proy.springapp.domain.Producto;

public class InMemoryProductoDAO implements ProductoDAO{

	private List<Producto> productoList;
	
	public InMemoryProductoDAO() {
		// TODO Auto-generated constructor stub
	}
		
	public InMemoryProductoDAO(List<Producto> productoList){
		this.productoList = productoList;
	}
	
	public List<Producto> getListProductos() {
		return productoList;
	}
	
	public void saveProducto(Producto pro){
		
	}	
}
