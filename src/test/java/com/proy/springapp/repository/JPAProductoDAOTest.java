package com.proy.springapp.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proy.springapp.domain.Producto;

public class JPAProductoDAOTest {

	private ApplicationContext context;
	private ProductoDAO productoDAO;
	
	@Before
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		productoDAO = (ProductoDAO) context.getBean("productoDAO");
	}
	
	@Test
	public void testGetListProductos(){
		List<Producto> productos = productoDAO.getListProductos();
		assertEquals(productos.size(), 3, 0);
	}
	
	@Test
	public void testSaveProducto(){
		List<Producto> productos = productoDAO.getListProductos();
		
		Producto p = productos.get(0);
		Double precio = p.getPrecio();
		p.setPrecio(200.12);
		productoDAO.saveProducto(p);
		
		List<Producto> updateProductos = productoDAO.getListProductos();
		Producto p2 = updateProductos.get(0);
		assertEquals(p2.getPrecio(), 200.12, 0);
		
		p2.setPrecio(precio);
		productoDAO.saveProducto(p2);
	}

}
