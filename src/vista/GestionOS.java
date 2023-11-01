/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author elbob
 */


import ObjectFp_Otros.LimpiarPantalla;
import controlador.Controlador;
import java.awt.AWTException;
import java.io.IOException;
import java.util.Scanner;
import modelo.Datos;
import modelo.ListaPedidos;
import modelo.Pedido;

public class GestionOS {
     
 
    private Controlador controlador;
    private Datos datos=new Datos();
    Scanner teclado = new Scanner(System.in);
    private LimpiarPantalla limpio =new LimpiarPantalla();
    public GestionOS() {
    controlador = new Controlador();
    }
    public void inicio()throws IOException,InterruptedException{
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
        limpio.ClearConsole();
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
                //limpio.ClearConsole();
                System.out.println("Menú de Gestión de Artículos");
                System.out.println("1. Agregar artículo al inventario");
                System.out.println("2. Mostrar artículos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        controlador.agregarArticuloNuevo();
                        break;
                    case '2':
                        
                        System.out.println("Mostrar artículos.................................\n");
                        System.out.println(controlador.obtenerListaArticulos());
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
            limpio.ClearConsole();
        }

        void gestionClientesMenu()throws IOException,InterruptedException {
            
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
                        System.out.println("\nAgregar Clientes.................................\n");
                        controlador.agregarCliente();
                        break;
                    case '2':
                       
                        System.out.println("\nMostrar Clientes.................................\n");
                        System.out.println(controlador.obtenerListaClientes());
                        
                        break;
                    case '3':
                         
                        System.out.println("\nMostrar clientes estandar.................................\n");
                        System.out.println(controlador.obtenerListaClientesEstandar());
                        break;
                    case '4':
                        //limpio.ClearConsole();
                        System.out.println("\nMostrar clientes premium.................................\n");
                        System.out.println(controlador.obtenerListaClientesPremium());
                        break;
                    case '0':
                        salir = true;
                        break;
                }
               
            } while (!salir);
            limpio.ClearConsole();
        }
        void gestionPedidosMenu() {
            boolean salir = false;
            char opcio;
            do {
                //limpio.ClearConsole();
                System.out.println("Menú de Gestión de Pedidos");
                System.out.println("1. Crear Pedido");
                System.out.println("2. Mostrar Pedidos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        //limpio.ClearConsole();
                        System.out.println("\nCrear pedido.................................\n");
                        datos.crearPedidoMenu();
                        
                        break;
                    case '2':
                        // TO-BE-DONE: Mostrar Pedidos
                         //limpio.ClearConsole();
                         System.out.println("\nObtener pedidos.................................\n");
                         System.out.println(controlador.obtenerListaPedidos());
                        break;
                    case '0':
                        salir = true;
                        break;
                }
            } while (!salir);
            limpio.ClearConsole();
        }
       
}
 
    
    