package modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArticuloTest {

    @Test
    public void testCrearArticulo() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        assertNotNull(articulo);
    }

    @Test
    public void testGetCodigo() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        assertEquals("TEST1", articulo.getCodigo());
    }

    @Test
    public void testSetCodigo() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        articulo.setCodigo("TEST2");
        assertEquals("TEST2", articulo.getCodigo());
    }

    @Test
    public void testGetDescripcion() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        assertEquals("MESA", articulo.getDescripcion());
    }

    @Test
    public void testSetDescripcion() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        articulo.setDescripcion("SILLA");
        assertEquals("SILLA", articulo.getDescripcion());
    }

    @Test
    public void testGetPrecioVenta() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        assertEquals(0.50, articulo.getPrecioVenta(), 0.001);
    }

    @Test
    public void testSetPrecioVenta() {
        Articulo articulo = new Articulo("TEST1", "MESA", 0.50, 0.05, 10);
        articulo.setPrecioVenta(0.75);
        assertEquals(0.75, articulo.getPrecioVenta(), 0.001);
    }
}