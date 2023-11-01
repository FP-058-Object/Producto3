/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testCrearClienteEstandar() {
        ClienteEstandar cliente = new ClienteEstandar("email@example.com", "Juan Perez", "Calle Falsa 123", "12345678A");
        assertNotNull(cliente);
    }

    @Test
    public void testTipoCliente() {
        ClienteEstandar cliente = new ClienteEstandar("email@example.com", "Juan Perez", "Calle Falsa 123", "12345678A");
        assertEquals("Estandar", cliente.tipoCliente());
    }

    @Test
    public void testCalcAnual() {
        ClienteEstandar cliente = new ClienteEstandar("email@example.com", "Juan Perez", "Calle Falsa 123", "12345678A");
        assertEquals(0, cliente.calcAnual(), 0.001);
    }

    @Test
    public void testDescuentoEnv() {
        ClienteEstandar cliente = new ClienteEstandar("email@example.com", "Juan Perez", "Calle Falsa 123", "12345678A");
        assertEquals(0, cliente.descuentoEnv(), 0.001);
    }

    @Test
    public void testGettersAndSetters() {
        ClienteEstandar cliente = new ClienteEstandar("email@example.com", "Juan Perez", "Calle Falsa 123", "12345678A");
        cliente.setEmail("nuevoemail@example.com");
        cliente.setNombre("Juan Perez Garcia");
        cliente.setDomicilio("Calle Verdadera 456");
        cliente.setNif("87654321B");

        assertEquals("nuevoemail@example.com", cliente.getEmail());
        assertEquals("Juan Perez Garcia", cliente.getNombre());
        assertEquals("Calle Verdadera 456", cliente.getDomicilio());
        assertEquals("87654321B", cliente.getNif());
    }
}