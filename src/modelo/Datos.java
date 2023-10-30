/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author elbob
 */
public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;
    
    public Datos () {
        listaArticulos = new ListaArticulos ();
        listaClientes = new ListaClientes ();
        listaPedidos = new ListaPedidos();
        
        cargarDatosEjemplo();
    }

    // Agregar un artículo a la lista de artículos
    public void agregarArticulo(Articulo articulo) {
        listaArticulos.agregar(articulo);
    }

    // Obtener una lista de todos los artículos
    public ArrayList<Articulo> obtenerArticulos() {
        return listaArticulos.obtenerLista();
    }

    // Agregar un cliente a la lista de clientes
    public void agregarCliente(Cliente cliente) {
        listaClientes.agregar(cliente);
    }

    // Obtener una lista de todos los clientes
    public ArrayList<Cliente> obtenerClientes() {
        return listaClientes.obtenerLista();
    }
    public ArrayList<Cliente> obtenerClientesEstandar() {
        ArrayList<Cliente> clientesEstandar = new ArrayList<>();

        for (Cliente cliente : listaClientes.obtenerLista()) {
            if (cliente instanceof ClienteEstandar) {
                clientesEstandar.add(cliente);
            }
        }

        return clientesEstandar;
    }
    public ArrayList<Cliente> obtenerClientesPremium() {
        ArrayList<Cliente> clientesPremium = new ArrayList<>();

        for (Cliente cliente : listaClientes.obtenerLista()) {
            if (cliente instanceof ClientePremium) {
                clientesPremium.add(cliente);
            }
            clientesPremium.toString();
        }

        return clientesPremium;
    }

    // Agregar un pedido a la lista de pedidos
    public void agregarPedido(Pedido pedido) {
        listaPedidos.agregar(pedido);
    }

    // Obtener una lista de todos los pedidos
    public ArrayList<Pedido> obtenerPedidos() {
        return listaPedidos.obtenerLista();
    }

    // Implementa otros métodos para gestionar datos, como eliminar, buscar, etc.

    // Ejemplo de un método para buscar un artículo por código
    public Articulo buscarArticuloPorCodigo(String codigo) {
        return listaArticulos.buscarPorCodigo(codigo);
    }

    // Ejemplo de un método para buscar un cliente por correo electrónico
    public Cliente buscarClientePorEmail(String email) {
        return listaClientes.buscarPorEmail(email);
    }

    // Ejemplo de un método para buscar un pedido por número de pedido
    public Pedido buscarPedidoPorNumero(int numeroPedido) {
        return listaPedidos.buscarPorNumero(numeroPedido);
    }
    
    
    
    
    
    
    
    
    
    
    
    private void cargarDatosEjemplo() {
        // Crear clientes de ejemplo
        ClienteEstandar cliente1 = new ClienteEstandar("Cliente1", "Dirección1", "NIF1", "cliente1@example.com");
        ClienteEstandar cliente2 = new ClienteEstandar("Cliente2", "Dirección2", "NIF2", "cliente2@example.com");
        ClientePremium cliente3 = new ClientePremium("Cliente3", "Dirección3", "NIF3", "cliente3@example.com");
        ClientePremium cliente4 = new ClientePremium("Cliente4", "Dirección4", "NIF4", "cliente4@example.com");

        // Agregar clientes a la lista de clientes
        listaClientes.agregar(cliente1);
        listaClientes.agregar(cliente2);
        listaClientes.agregar(cliente3);
        listaClientes.agregar(cliente4);

        // Crear artículos de ejemplo
        Articulo articulo1 = new Articulo("A001", "Artículo 1", 10.0, 5.0, 30);
        Articulo articulo2 = new Articulo("A002", "Artículo 2", 15.0, 6.0, 40);

        // Agregar artículos a la lista de artículos
        listaArticulos.agregar(articulo1);
        listaArticulos.agregar(articulo2);

        // Crear pedidos de ejemplo
        Pedido pedido1 = new Pedido(1, cliente1, articulo1, 2, new Date(), true);
        Pedido pedido2 = new Pedido(2, cliente2, articulo2, 1, new Date(), false);


        // Agregar pedidos a la lista de pedidos
        listaPedidos.agregar(pedido1);
        listaPedidos.agregar(pedido2);
    }


}
