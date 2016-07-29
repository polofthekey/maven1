package com.proy.springapp.repository;

import java.util.List;

import com.proy.springapp.domain.Producto;

public interface ProductoDAO {

	public List<Producto> getListProductos();
	
	public void saveProducto(Producto pro);

}
