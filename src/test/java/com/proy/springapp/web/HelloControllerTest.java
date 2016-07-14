package com.proy.springapp.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
    @Test
    public void testHandleRequestView() throws Exception{		
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String valorAhora = (String) modelAndView.getModel().get("ahora");
        assertNotNull(valorAhora);
        //assertEquals("hello.jsp", modelAndView.getViewName());
    }

}
