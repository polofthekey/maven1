package com.proy.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proy.springapp.service.IncrementaPrecio;
import com.proy.springapp.service.ProductoManager;

@Controller
@RequestMapping(value="/incrementaprecio.htm")
public class IncrementaPrecioFormController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProductoManager productoManager;
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid IncrementaPrecio incrementaPrecio, BindingResult result)
	{
		if(result.hasErrors()){
			return "incrementaprecio";
		}
		
		int incremento = incrementaPrecio.getPorcentaje();
		logger.info("Incrementa precio por: " + incremento + "%.");
		
		productoManager.incrementarPrecio(incremento);
		
		return "redirect:/hello.htm";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	protected IncrementaPrecio formBackingObject(HttpServletRequest request) throws ServletException{
		IncrementaPrecio incrementaPrecio = new IncrementaPrecio();
		incrementaPrecio.setPorcentaje(15);
		return incrementaPrecio;		
	}
	
	public void setProductoManager(ProductoManager productoManager){
		this.productoManager = productoManager;
	}
	
	public ProductoManager getProductoManager(){
		return productoManager;
	}
	
	/*public IncrementaPrecioFormController() {
		// TODO Auto-generated constructor stub
	}*/
}
