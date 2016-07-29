package com.proy.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proy.springapp.domain.Producto;

@Repository(value = "productoDAO")
public class JPAProductoDAO implements ProductoDAO{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}	
	
	public JPAProductoDAO() {
		// TODO Auto-generated constructor stub
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Producto> getListProductos() {		
		return em.createQuery("SELECT p FROM Producto p ORDER BY p.id").getResultList();
	}

	@Transactional(readOnly = false)
	public void saveProducto(Producto pro) {
		em.merge(pro);		
	}

}
