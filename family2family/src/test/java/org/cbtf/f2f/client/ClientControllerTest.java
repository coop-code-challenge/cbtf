package org.cbtf.f2f.client;

import junit.framework.TestCase;

public class ClientControllerTest extends TestCase {
    public void testGetIndex() {
        ClientController clientController = new ClientController();
        String index = clientController.getIndex();
        assertEquals("index", index);
    }
}