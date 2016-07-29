package com.proy.springapp.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import com.proy.springapp.domain.Producto;
import com.proy.springapp.repository.InMemoryProductoDAO;
import com.proy.springapp.repository.ProductoDAO;

import org.junit.Before;
import org.junit.Test;

public class SimpleProductoManagerTest {

	private SimpleProductoManager productoManager;
	
	private List<Producto> productos;
	
	private static int PRODUCTO_COUNT = 2;
	
	private static Double SILLA_PRECIO = new Double(20.50);
	private static String SILLA_DESCRIPCION = "Silla";
	
	private static String MESA_DESCRIPCION = "Mesa";
	private static Double MESA_PRECIO = new Double(150.10);
	
	private static int PRECIO_POSITIVO = 10;
	
	@Before
	public void setUp() throws Exception{
		productoManager = new SimpleProductoManager();
		productos = new ArrayList<Producto>();
		
		Producto producto = new Producto();
		producto.setDescripcion("Silla");
		producto.setPrecio(SILLA_PRECIO);
		productos.add(producto);
		
		producto = new Producto();
		producto.setDescripcion("Mesa");
		producto.setPrecio(MESA_PRECIO);
		productos.add(producto);
		
		ProductoDAO productoDAO = new InMemoryProductoDAO(productos);
		productoManager.setProductoDAO(productoDAO);
		//Se sustituye
		//productoManager.setProductos(productos);
	}
	
	@Test
	public void testGetProductWithNoProducts() {
		productoManager = new SimpleProductoManager();
		productoManager.setProductoDAO(new InMemoryProductoDAO());
		assertNull(productoManager.getProductos());
	}
	
	@Test
	public void testGetProductos(){
		List<Producto> productos = productoManager.getProductos();
		assertNotNull(productos);
		assertEquals(PRODUCTO_COUNT, productoManager.getProductos().size());
		
		Producto producto = productos.get(0);
		assertEquals(SILLA_DESCRIPCION, producto.getDescripcion());
		assertEquals(SILLA_PRECIO, producto.getPrecio());
		
		producto = productos.get(1);
		assertEquals(MESA_DESCRIPCION, producto.getDescripcion());
		assertEquals(MESA_PRECIO, producto.getPrecio());
	}
	
	@Test
	public void testIncrementaPrecioConNullListdeProducts(){
		try{
			productoManager = new SimpleProductoManager();
			productoManager.setProductoDAO(new InMemoryProductoDAO(new ArrayList<Producto>()));
			//productoManager.setProductos(new ArraList<Producto>());
			productoManager.incrementarPrecio(PRECIO_POSITIVO);				
		}
		catch(NullPointerException e){
			fail("La lista de productos esta vacía.");
		}
	}
	
	@Test
	public void testIncrementaPrecioConPorcentajePositivo(){
		productoManager.incrementarPrecio(PRECIO_POSITIVO);
		double precioEsperadoSillaConIncremento = 22.55;
		double precioEsperadoMesaConIncremento = 165.11;
		
		List<Producto> productos = productoManager.getProductos();
		Producto producto = productos.get(0);
		assertEquals(precioEsperadoSillaConIncremento, producto.getPrecio(), 0);
		
		producto = productos.get(1);
		assertEquals(precioEsperadoMesaConIncremento, producto.getPrecio(), 0);
	}

}
