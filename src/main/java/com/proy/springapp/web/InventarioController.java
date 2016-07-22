package com.proy.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proy.springapp.service.ProductoManager;



@Controller
public class InventarioController {	
	// TODO Auto-generated constructor stub
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProductoManager productoManager;

    @RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String ahora = (new Date()).toString();
        logger.info("Regresando vista de hello " + ahora);
        
        Map<String, Object> miModelo = new HashMap<String, Object>();
        miModelo.put("ahora", ahora);
        miModelo.put("productos", this.productoManager.getProductos());
        
        return new ModelAndView("hola", "modelo", miModelo);

        //return new ModelAndView("hello.jsp");
        //return new ModelAndView("hola", "ahora", ahora);
    }
    
    public void setProductoManager(ProductoManager productoManager){
    	this.productoManager = productoManager;
    }
}
