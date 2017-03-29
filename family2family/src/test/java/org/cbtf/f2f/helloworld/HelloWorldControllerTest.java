package org.cbtf.f2f.helloworld;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldControllerTest {
    @Test
    public void testGetHello() {
        HelloWorldController service = new HelloWorldController();
        String response = service.getHello("Justin");
        assertEquals("Hello, Justin", response);
    }
}
