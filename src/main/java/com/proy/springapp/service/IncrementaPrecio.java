package com.proy.springapp.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IncrementaPrecio {

	public IncrementaPrecio() {
		// TODO Auto-generated constructor stub
	}
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Min(0)
	@Max(50)
	private int porcentaje;
		
	public void setPorcentaje(int i){
		this.porcentaje = i;
		logger.info("Porcentaje asignado de " + i);
	}
	
	public int getPorcentaje(){
		return porcentaje;
	}

}
