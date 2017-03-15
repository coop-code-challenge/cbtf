package org.cbtf.f2f.helloworld;

import junit.framework.TestCase;

public class HelloWorldServiceTest extends TestCase {
    public void testGetHello() {
        HelloWorldService service = new HelloWorldService();
        String response = service.getHello("Justin");
        assertEquals("Hello, Justin", response);
    }
}
