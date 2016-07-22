package com.proy.springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.proy.springapp.service.SimpleProductoManager;

public class InventarioControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
    @Test
    public void testHandleRequestView() throws Exception{		
        InventarioController controller = new InventarioController();
        controller.setProductoManager(new SimpleProductoManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hola", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("modelo");
        String valorAhora = (String) modelAndView.getModel().get("ahora");
        assertNotNull(valorAhora);
        //assertEquals("hello.jsp", modelAndView.getViewName());
    }

}
