/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatosTest {
    
    Datos datos;
    
    @Before
    public void setUp() {
        datos = new Datos();
    }
    
    @Test
    public void testAgregarArticulo() {
        Articulo articulo = datos.anadirArticulo("A003", "Articulo 3", 20.0, 7.0, 50);
        assertNotNull(articulo);
        assertEquals("A003", articulo.getCodigo());
        assertEquals("Articulo 3", articulo.getDescripcion());
        assertEquals(20.0, articulo.getPrecioVenta(), 0.001);
        assertEquals(7.0, articulo.getGastosEnvio(), 0.001);
        assertEquals(50, articulo.getTiempoPreparacionMinutos());
    }
    
    @Test
    public void testAgregarClienteEstandar() {
        Cliente cliente = datos.agregarClienteEstandar("cliente6@example.com", "Cliente6", "Direccion6", "NIF6");
        assertNotNull(cliente);
        assertTrue(cliente instanceof ClienteEstandar);
        assertEquals("cliente6@example.com", cliente.getEmail());
        assertEquals("Cliente6", cliente.getNombre());
        assertEquals("Direccion6", cliente.getDomicilio());
        assertEquals("NIF6", cliente.getNif());
    }
    
    @Test
    public void testAgregarClientePremium() {
        Cliente cliente = datos.agregarClientePremium("cliente7@example.com", "Cliente7", "Direccion7", "NIF7");
        assertNotNull(cliente);
        assertTrue(cliente instanceof ClientePremium);
        assertEquals("cliente7@example.com", cliente.getEmail());
        assertEquals("Cliente7", cliente.getNombre());
        assertEquals("Direccion7", cliente.getDomicilio());
        assertEquals("NIF7", cliente.getNif());
    }
    
}