/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import java.util.List;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;
/**
 *
 * @author elbob
 */
public class Controlador {
    private Datos datos;
    
    public Controlador() {
        datos = new Datos();
    }
    public ArrayList<Cliente> obtenerListaClientes() {
        return datos.obtenerClientes();
    }

    public ArrayList<Cliente> obtenerListaClientesEstandar() {
        return datos.obtenerClientesEstandar();
    }

    public ArrayList<Cliente> obtenerListaClientesPremium() {
        return datos.obtenerClientesPremium();
    }

    public ArrayList<Articulo> obtenerListaArticulos() {
        return datos.obtenerArticulos();
    }
    public ArrayList<Pedido> obtenerListaPedidos() {
        return datos.obtenerPedidos();
   }
}
