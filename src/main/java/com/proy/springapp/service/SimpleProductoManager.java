package com.proy.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proy.springapp.domain.Producto;
import com.proy.springapp.repository.ProductoDAO;

@Component
public class SimpleProductoManager implements ProductoManager{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductoDAO productoDAO;

	//Se crea ahra dentro del método
	//private List<Producto> productos;
	
	public List<Producto> getProductos() {
		return productoDAO.getListProductos();
	}


	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}


	public SimpleProductoManager() {
		// TODO Auto-generated constructor stub
	}

	
	public void incrementarPrecio(int porcentaje) {		
		List<Producto> productos = productoDAO.getListProductos();
		if (productos != null){
			for (Producto producto : productos){
				double nuevoPrecio = producto.getPrecio().doubleValue() * (100 + porcentaje)/100;
				producto.setPrecio(nuevoPrecio);
				productoDAO.saveProducto(producto);
			}
		}
	}
	//Se sustituye por la persistencia en base
	/*public List<Producto> getProductos() {
		//throw new UnsupportedOperationException();
		return productos;
	}
	
	public void setProductos(List<Producto> productos){
		//throw new UnsupportedOperationException();
		this.productos = productos;
	}*/

}
