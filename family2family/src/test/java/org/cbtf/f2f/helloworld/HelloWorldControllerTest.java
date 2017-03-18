package org.cbtf.f2f.helloworld;

import junit.framework.TestCase;

public class HelloWorldControllerTest extends TestCase {
    public void testGetHello() {
        HelloWorldController service = new HelloWorldController();
        String response = service.getHello("Justin");
        assertEquals("Hello, Justin", response);
    }
}
