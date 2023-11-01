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
import java.util.Date;
import java.util.Scanner;
import java.util.Scanner;

public class GestionOS {
     
 
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in, "UTF-8");
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
        //GESTION ARTICULOS
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
                        añadirArticulo();
                        break;
                    case '2':
                        controlador.obtenerListaArticulos();
                        break;
                    case '0':
                        inicio();
                        break;
                }
            } while (!salir);
        }
        
        public void añadirArticulo(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Añadir articulo");
            System.out.println("2. Atrás");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Indica el codigo del artículo: ");
                    scanner.nextLine(); // Consumir la nueva línea restante
                    String codigoArticuloNuevo = scanner.nextLine();
                    System.out.print("Indica la descripción del artículo: ");
                    String descripcionArticuloNuevo = scanner.nextLine();
                    System.out.print("Indica el precio de venta del artículo: ");
                    double precioVentaArticuloNuevo = scanner.nextDouble();
                    System.out.print("Indica los gastos de envío del artículo: ");
                    double gastosEnvioArticuloNuevo = scanner.nextDouble();
                    System.out.print("Indica el tiempo de preparación del artículo (min): ");
                    int tiempoPreparacionMinutosArticuloNuevo = scanner.nextInt();

                    controlador.anadirArticulo(codigoArticuloNuevo, descripcionArticuloNuevo, precioVentaArticuloNuevo, gastosEnvioArticuloNuevo, tiempoPreparacionMinutosArticuloNuevo);
                    break;

                case 2:
                    gestionArticulosMenu();
            }
        } 
        while (opcion != 0);
   
        }
        //GESTION CLIENTES
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
                        añadirCliente();
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
                        inicio();
                        break;
                }
            } while (!salir);
        }
        public void añadirCliente(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Cliente Estándar");
            System.out.println("2. Cliente Premium");
            System.out.println("3. Atrás");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Indica el nombre del cliente: ");
                    scanner.nextLine(); // Consumir la nueva línea restante
                    String nombreClienteNuevoEstandar = scanner.nextLine();
                    System.out.print("Indica el email del cliente: ");
                    String emailClienteNuevoEstandar = scanner.nextLine();
                    System.out.print("Indica la direccion del cliente: ");
                    String direccionClienteNuevoEstandar = scanner.nextLine();
                    System.out.print("Indica el nif del cliente: ");
                    String nifClienteNuevoEstandar = scanner.nextLine();
 
                    controlador.agregarClienteEstandar(emailClienteNuevoEstandar, nombreClienteNuevoEstandar, direccionClienteNuevoEstandar, nifClienteNuevoEstandar);
                    break;
                case 2:
                    System.out.print("Indica el nombre del cliente: ");
                    scanner.nextLine(); // Consumir la nueva línea restante
                    String nombreClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica el email del cliente: ");
                    String emailClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica la direccion del cliente: ");
                    String direccionClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica el nif del cliente: ");
                    String nifClienteNuevoPremium = scanner.nextLine();
 
                    controlador.agregarClientePremium(emailClienteNuevoPremium, nombreClienteNuevoPremium, direccionClienteNuevoPremium, nifClienteNuevoPremium);
                    break;
                case 3:
                    gestionClientesMenu();
            }
        } 
        while (opcion != 0);
        // GESTION PEDIDOS
        }

        void gestionPedidosMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Pedidos");                                                                   
                System.out.println("1. Agregar Pedido");
                System.out.println("2. Eliminar Pedidos");
                System.out.println("3. Mostrar Pedidos");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        añadirPedido();
                        break;
                    case '2':
                        System.out.print("Indica el número del pedido: ");
                        int numeroPedidoEliminar = scanner.nextInt ();
                        controlador.eliminarPedido(numeroPedidoEliminar);
                        gestionPedidosMenu();
                        break;
                    case '3':
                        obtenerPedidosMenu();
                        break;
                    case '0':
                        inicio();
                        break;
                }
            } while (!salir);
        
        }
        public void añadirPedido(){
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("1. Añadir pedido");
                System.out.println("2. Atrás");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Indica el email del cliente: ");
                        scanner.nextLine(); // Consumir la nueva línea restante
                        String emailClientePedidoNuevo = scanner.nextLine();
                        boolean emailExiste = controlador.comprobarEmailPedidoNuevo(emailClientePedidoNuevo);
                        if ( emailExiste == true){
                            añadirPedido2(emailClientePedidoNuevo);
                        }
                        else{
                            System.out.println("El cliente no existe, tienes que añadirlo ");
                            añadirCliente();
                        }
                    case 2:
                        gestionClientesMenu();
                }
            } 
            while (opcion != 0);
        }
        
        public void añadirPedido2(String emailClientePedidoNuevo){
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("1. Continuar añadiendo pedido");
                System.out.println("2. Atrás");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Indica el número de pedido: ");
                        scanner.nextLine(); // Consumir la nueva línea restante
                        int numeroPedidoNuevo = scanner.nextInt();
                        System.out.print("Indica la cantidad: ");
                        int cantidadPedidoNuevo = scanner.nextInt();
                        System.out.print("Indica el código del artículo: ");
                        int codigoPedidoNuevo = scanner.nextInt();
                        Date fechaPedidoNuevo = new Date();
                        controlador.buscarArticuloPorCodigo(codigoPedidoNuevo);
                        controlador.crearPedidoNuevo(numeroPedidoNuevo, cantidadPedidoNuevo, fechaPedidoNuevo, emailClientePedidoNuevo, codigoPedidoNuevo);

           
                    case 2:
                        gestionClientesMenu();
                }
            } 
            while (opcion != 0);
        }
        
        
        
        
       
        
        // GESTION PEDIDOS
        
        void obtenerPedidosMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Pedidos");
                System.out.println("1. Pedidos pendientes");
                System.out.println("2. Pedidos enviados");
                System.out.println("3. Atrás");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        System.out.print("Indica el email del cliente: ");
                        String emailClientePendientes = scanner.nextLine();
                        controlador.obtenerPedidosPendientes(emailClientePendientes);
                        break;
                    case '2':
                        System.out.print("Indica el email del cliente: ");
                        String emailClienteEnviados = scanner.nextLine();
                        controlador.obtenerPedidosEnviados(emailClienteEnviados);
                        break;
                    case '3':
                        gestionPedidosMenu();
                        break;
                }
            } while (!salir);
        
        }
}
 
    
    