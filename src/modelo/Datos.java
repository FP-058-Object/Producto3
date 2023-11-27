/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;
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
    //Gestion Articulos
        // Agregar un artículo a la lista de artículos
    public Articulo añadirArticulo(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacionMinutos) {
        
        Articulo nuevoArticulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacionMinutos);
        listaArticulos.agregar(nuevoArticulo);
        System.out.println("Artículo creado: " + nuevoArticulo.toString());
        return nuevoArticulo;
    }
        // Obtener una lista de todos los artículos
    public ArrayList<Articulo> obtenerArticulos() {
        return listaArticulos.obtenerLista();
    }
    
    //Gestion CLientes
        // Agregar un cliente a la lista de clientes
    public Cliente agregarClienteEstandar(String email, String nombre, String domicilio, String nif) {
        Cliente nuevoClienteEstandar = new ClienteEstandar (email, nombre, domicilio, nif);
        listaClientes.agregar(nuevoClienteEstandar);
        System.out.println("Has añadido al cliente Estándar: " + nuevoClienteEstandar.toString());
        return nuevoClienteEstandar;
    }
    public Cliente agregarClientePremium(String email, String nombre, String domicilio, String nif) {
        Cliente nuevoClientePremium = new ClientePremium (email, nombre, domicilio, nif);
        listaClientes.agregar(nuevoClientePremium);
        System.out.println("Has añadido al cliente Estándar: " + nuevoClientePremium.toString());
        return nuevoClientePremium;
    }

        // Obtener una lista de todos los clientes
    public ArrayList<Cliente> obtenerClientes() {
        return listaClientes.obtenerLista();
    }
        // Obtener listas flitradas por Estadar/Premium
    public ArrayList<Cliente> obtenerClientesEstandar() {
        ArrayList<Cliente> clientesEstandar = new ArrayList<>();

        for (Cliente cliente : listaClientes.obtenerDatosLista()) {
            if (cliente instanceof ClienteEstandar) {
                System.out.println(cliente.toString());
            }
        }
        return clientesEstandar;
    }
        public ArrayList<Cliente> obtenerClientesPremium() {
            ArrayList<Cliente> clientesPremium = new ArrayList<>();

            for (Cliente cliente : listaClientes.obtenerDatosLista()) {
                if (cliente instanceof ClientePremium) {
                    System.out.println(cliente.toString());
                }
            }
            return clientesPremium;
        }

        //Gestion Pedidos
            // Agregar un pedido a la lista de pedidos
        public void agregarPedido(Pedido pedido) {
            listaPedidos.agregar(pedido);
        }

            // Obtener una lista de todos los pedidos
        public ArrayList<Pedido> obtenerPedidos() {
            return listaPedidos.obtenerLista();
        }

        //Comprobar email cliente
        public boolean comprobarEmailPedidoNuevo(String email) {
            for (Cliente cliente : listaClientes.obtenerDatosLista()) {
                System.out.println("Comparando con email: " + cliente.getEmail());
                if (cliente.getEmail().equals(email)) {
                    System.out.println("Cliente encontrado :" + cliente.toString());
                    return true; // Cliente encontrado
                }
            }
            System.out.println("Cliente no encontrado.");
            return false; // Cliente no encontrado
        }
            //Buscar cliente por email
        public Cliente buscarClientePorEmailPendiente(String email) {
            for (Cliente cliente : listaClientes.obtenerDatosLista()) {
                System.out.println("Comparando con email: " + cliente.getEmail());
                if (cliente.getEmail().equals(email)) {
                    System.out.println("Cliente encontrado :" + cliente.toString());
                    obtenerPedidosPendientesCliente(cliente);
                    return cliente; // Cliente encontrado
                }
            }
            System.out.println("Cliente no encontrado.");
            return null; // Cliente no encontrado
        }
        public Cliente buscarClientePorEmailEnviado(String email) {
            for (Cliente cliente : listaClientes.obtenerDatosLista()) {
                System.out.println("Comparando con email: " + cliente.getEmail());
                if (cliente.getEmail().equals(email)) {
                    System.out.println("Cliente encontrado :" + cliente.toString());
                    obtenerPedidosEnviadosCliente(cliente);
                    return cliente; // Cliente encontrado
                }
            }
            System.out.println("Cliente no encontrado.");
            return null; // Cliente no encontrado
        }

        public Cliente obtenerClientePedidoNuevo(String email) {
            for (Cliente cliente : listaClientes.obtenerDatosLista()) {
                if (cliente.getEmail().equals(email)) {
                    return cliente; // Cliente encontrado
                }
            }

            return null; // Cliente no encontrado
        }

    
        // Obetener lista de los pedidos enviados de un cliente
        public ArrayList<Pedido> obtenerPedidosPendientesCliente(Cliente cliente) {
            ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();

            for (Pedido pedido : listaPedidos.obtenerDatosLista()) {
                if (pedido.getCliente().equals(cliente)) {
                long tiempoTranscurrido = calcularTiempoTranscurrido(pedido.getFechaHoraPedido());

                    if (tiempoTranscurrido < pedido.articulo.getTiempoPreparacionMinutos()) {
                      System.out.println(pedido.toString());
                    }
                    else{
                            //System.out.println("No se han encontrado pedidos pendientes");
                        }
                }
            }
                return pedidosFiltrados;
            }
    
        public ArrayList<Pedido> obtenerPedidosEnviadosCliente(Cliente cliente) {
            ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();

            for (Pedido pedido : listaPedidos.obtenerDatosLista()) {
                if (pedido.getCliente().equals(cliente)) {
                long tiempoTranscurrido = calcularTiempoTranscurrido(pedido.getFechaHoraPedido());

                    if (tiempoTranscurrido > pedido.articulo.getTiempoPreparacionMinutos()) {
                        System.out.println(pedido.toString());
                    }
                    else{
                        //System.out.println("No se han encontrado pedidos enviados");
                    }
                }
            }
                return pedidosFiltrados;
            }
        
        public boolean eliminarPedido(int numeroPedido) {
            for (Pedido pedido : listaPedidos.obtenerDatosLista()) {
                if (pedido.getNumeroPedido() == numeroPedido && !pedido.pedidoEnviado()) {
                    // Verificamos si el pedido no ha sido enviado (enviado == false)
                    listaPedidos.eliminar(pedido);
                    System.out.println("El pedido se eliminó exitosamente");
                    return true; 
                }
            }
            System.out.println("El pedido no se encontró o ya ha sido enviado");
            return false;
        }
        
        public Articulo buscarArticuloPorCodigo(String codigo) {
            for (Articulo articulo : listaArticulos.obtenerDatosLista()) {
                if (articulo.getCodigo().equals(codigo)) {
                    return articulo; 
                }
            }
            System.out.println("Artículo no encontrado");
            return null;  
        }
        
        public Pedido crearPedidoNuevo(int numero, Cliente cliente, Articulo articulo, int cantidad, Date fecha) {
            Pedido pedidoNuevo = new Pedido(numero, cliente, articulo, cantidad, fecha); 
            listaPedidos.agregar(pedidoNuevo); // Agrega el nuevo pedido a la lista de pedidos
            System.out.println("Pedido creado con éxito /n" + pedidoNuevo.toString());
            return pedidoNuevo;
        }
        



    private long calcularTiempoTranscurrido(Date fechaPedido) {
        // Obtiene la fecha y hora actual
        Date fechaActual = new Date();

        // Convierte las fechas a objetos Calendar
        Calendar calendarPedido = Calendar.getInstance();
        calendarPedido.setTime(fechaPedido);
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(fechaActual);

        // Calcula la diferencia en milisegundos
        long diferenciaEnMilisegundos = calendarActual.getTimeInMillis() - calendarPedido.getTimeInMillis();

        // Convierte la diferencia a minutos
        long minutosTranscurridos = diferenciaEnMilisegundos / (60 * 1000);
        
        return minutosTranscurridos;
    }
    
    
    


    
    private void cargarDatosEjemplo() {
        // Crear clientes de ejemplo
        ClienteEstandar cliente1 = new ClienteEstandar("111", "Cliente1", "Dirección1", "NIF1");
        ClienteEstandar cliente2 = new ClienteEstandar("cliente2@example.com", "Cliente2", "Dirección2", "NIF2");
        ClienteEstandar cliente3 = new ClienteEstandar("cliente3@example.com", "Cliente3", "Dirección3", "NIF3");
        ClienteEstandar cliente4 = new ClienteEstandar("cliente4@example.com", "Cliente4", "Dirección4", "NIF4");
        ClienteEstandar cliente5 = new ClienteEstandar("cliente5@example.com", "Cliente5", "Dirección5", "NIF5");


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
        Pedido pedido1 = new Pedido(1, cliente1, articulo1, 2, new Date());
        Pedido pedido2 = new Pedido(2, cliente2, articulo2, 1, new Date());
        Pedido pedido3 = new Pedido(3, cliente1, articulo2, 3, new Date());
        Pedido pedido4 = new Pedido(4, cliente2, articulo1, 2, new Date());
        Pedido pedido5 = new Pedido(5, cliente1, articulo1, 1, new Date());
        
        Date fechaAnterior1 = new Date(System.currentTimeMillis() - 86400000); // Un día antes
        Pedido pedido6 = new Pedido(6, cliente1, articulo2, 2, fechaAnterior1);
        Date fechaAnterior2 = new Date(System.currentTimeMillis() - 172800000); // Dos días antes
        Pedido pedido7 = new Pedido(7, cliente2, articulo1, 3, fechaAnterior2);
        Date fechaAnterior3 = new Date(System.currentTimeMillis() - 259200000); // Tres días antes
        Pedido pedido8 = new Pedido(8, cliente1, articulo1, 4, fechaAnterior3);
        Date fechaAnterior4 = new Date(System.currentTimeMillis() - 345600000); // Cuatro días antes
        Pedido pedido9 = new Pedido(9, cliente2, articulo2, 1, fechaAnterior4);
        Date fechaAnterior5 = new Date(System.currentTimeMillis() - 432000000); // Cinco días antes
        Pedido pedido10 = new Pedido(10, cliente1, articulo1, 3, fechaAnterior5);

        // Agregar pedidos a la lista de pedidos
        listaPedidos.agregar(pedido1);
        listaPedidos.agregar(pedido2);
        listaPedidos.agregar(pedido3);
        listaPedidos.agregar(pedido4);
        listaPedidos.agregar(pedido5);
        listaPedidos.agregar(pedido6);
        listaPedidos.agregar(pedido7);
        listaPedidos.agregar(pedido8);
        listaPedidos.agregar(pedido9);
        listaPedidos.agregar(pedido10);
    }


}
