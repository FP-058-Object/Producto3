/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

public class PedidoTest {
    private Pedido pedido;
    private Cliente cliente;
    private Articulo articulo;

    @Before
    public void setUp() throws Exception {
        cliente = new ClienteEstandar("nombre", "email@example.com", "direccion", "12345678A");
        articulo = new Articulo("codigo", "descripcion", 10.0, 5.0, 30);
        pedido = new Pedido(1, cliente, articulo, 5, new Date());
    }

    @Test
    public void testPrecioEnvio() {
        assertEquals("El precio de envio no es correcto", 25.0, pedido.precioEnvio(), 0.0);
    }


    @Test
    public void testSetNumeroPedido() {
        pedido.setNumeroPedido(2);
        assertEquals("El numero de pedido no se ha actualizado correctamente", 2, pedido.getNumeroPedido());
    }

    @Test
    public void testSetCliente() {
        Cliente nuevoCliente = new ClientePremium("otroNombre", "otroEmail@example.com", "otraDireccion", "87654321B");
        pedido.setCliente(nuevoCliente);
        assertEquals("El cliente no se ha actualizado correctamente", nuevoCliente, pedido.getCliente());
    }

    @Test
    public void testSetArticulo() {
        Articulo nuevoArticulo = new Articulo("nuevoCodigo", "nuevaDescripcion", 20.0, 10.0, 60);
        pedido.setArticulo(nuevoArticulo);
        assertEquals("El articulo no se ha actualizado correctamente", nuevoArticulo, pedido.getArticulo());
    }

    @Test
    public void testSetCantidad() {
        pedido.setCantidad(10);
        assertEquals("La cantidad no se ha actualizado correctamente", 10, pedido.getCantidad());
    }

    @Test
    public void testSetFechaHoraPedido() {
        Date nuevaFecha = new Date();
        pedido.setFechaHoraPedido(nuevaFecha);
        assertEquals("La fecha y hora del pedido no se ha actualizado correctamente", nuevaFecha, pedido.getFechaHoraPedido());
    }

    @Test
    public void testToString() {
        assertNotNull("El metodo toString no deberia retornar null", pedido.toString());
    }
}