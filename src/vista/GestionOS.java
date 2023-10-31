/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author elbob
 */


import controlador.Controlador;
import java.util.Scanner;
import java.util.Scanner;
import modelo.Datos;

public class GestionOS {
     
 
    private Controlador controlador;
    private Datos datos=new Datos();
    Scanner teclado = new Scanner(System.in);
   
    public GestionOS() {
    controlador = new Controlador();
    }
    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
        System.out.println("1. Gestión Articulos");
        System.out.println("2. Gestión Clientes");
        System.out.println("3. Gestión Pedidos");
        System.out.println("0. Salir");
        opcio = pedirOpcion();
        switch (opcio) {
        case '1':
        gestionArticulosMenu();
        break;
        case '2':
        gestionClientesMenu();
        break;
        case '3':
        gestionPedidosMenu();
        break;
        case '0':
        salir = true;
            }
        } while (!salir);
        }
        char pedirOpcion() {
            String resp;
            System.out.println("Elige una opción (1,2,3 o 0):");
        
            resp = teclado.nextLine();
            if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }
        
        void gestionArticulosMenu() {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Artículos");
                System.out.println("1. Agregar artículo al inventario");
                System.out.println("2. Mostrar artículos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                       // controlador.crearArticulo();
                        break;
                    case '2':
                        controlador.obtenerListaArticulos();
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
        }

        void gestionClientesMenu() {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Clientes");
                System.out.println("1. Agregar cliente");
                System.out.println("2. Mostrar clientes");
                System.out.println("3. Mostrar clientes estándar");
                System.out.println("4. Mostrar clientes premium");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        //controlador.agregarCliente();
                        break;
                    case '2':
                        controlador.obtenerListaClientes();
                      
                        break;
                    case '3':
                        controlador.obtenerListaClientesEstandar();
                        break;
                    case '4':
                        controlador.obtenerListaClientesPremium();
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
        }
        void gestionPedidosMenu() {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Pedidos");
                System.out.println("1. Crear Pedido");
                System.out.println("2. Mostrar Pedidos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        datos.crearPedidoMenu();
                        
                        break;
                    case '2':
                        // TO-BE-DONE: Mostrar Pedidos
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
        }
        void crearPedidoMenu() {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Pedidos");
                System.out.println("1. Agregar Pedido");
                System.out.println("2. Mostrar Pedidos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        //crearPedido(teclado);
                        break;
                    case '2':
                        controlador.obtenerListaPedidos();
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
        
    }
}
 
    
    