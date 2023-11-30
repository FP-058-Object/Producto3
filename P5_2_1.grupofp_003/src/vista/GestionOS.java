/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author elbob
 */


import modelo.DAOException;
import controlador.Controlador;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;



public class GestionOS {
     
 
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in, "UTF-8");
    public GestionOS() {
    controlador = new Controlador();
    }
    public void inicio() throws DAOException, SQLException, ClassNotFoundException {
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
        void gestionArticulosMenu() throws DAOException, SQLException, ClassNotFoundException {
            boolean salir = false;
            char opcio;
            do {
                System.out.println("Menú de Gestión de Artículos");
                System.out.println("1. Agregar artículo al inventario");
                System.out.println("2. Mostrar artículos");
                System.out.println("3. Eliminar artículo");
                System.out.println("4. Modificar artículo");
                System.out.println("0. Volver al Menú Principal");
                opcio = pedirOpcion();
                switch (opcio) {
                    case '1':
                        añadirArticulo();
                        break;
                    case '2':
                       try {
                                List<Articulo> lista = controlador.obtenerListaArticulos();
                                for (Articulo a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        break;
                    case '3':
                        try {
                                List<Articulo> lista = controlador.obtenerListaArticulos();
                                for (Articulo a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        EliminarArticulo();
                        break;
                    case '4':
                        try {
                                List<Articulo> lista = controlador.obtenerListaArticulos();
                                for (Articulo a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        modificarArticulo();
                        break;
                    case '0':
                        inicio();
                        break;
                }
            } while (!salir);
        }
        /*-------------------AÑADIR--------------------------------------ARTICULO--------------*/
        public void añadirArticulo() throws DAOException, SQLException, ClassNotFoundException{
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int opcion;
        do {
            System.out.println("1. Añadir articulo");
            System.out.println("2. Atrás");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    //Obtener lista articulo primero
                    try {
                                List<Articulo> lista = controlador.obtenerListaArticulos();
                                for (Articulo a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                   // Ingresar el código del artículo
                    scanner.nextLine();
                    System.out.print("Indica el codigo del artículo: "); 
                    String codigoArticuloNuevo = scanner.nextLine();
                    // Ingresar la descripción del artículo
                    System.out.print("Indica la descripción del artículo: ");
                    String descripcionArticuloNuevo = scanner.nextLine();
                   
                    // Ingresar el precio de venta del artículo
                    double precioVentaArticuloNuevo = 0;
                    boolean precioValido = false;
                    while (!precioValido) {
                        try {
                            System.out.print("Indica el precio de venta del artículo: ");
                            precioVentaArticuloNuevo = scanner.nextDouble();
                            if (precioVentaArticuloNuevo >= 0) {
                                precioValido = true;
                            } else {
                                System.out.println("El precio debe ser un número positivo.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, ingresa un valor numérico válido.");
                            scanner.nextLine(); // Limpiar el buffer del scanner
                        }
                    }

                    // Ingresar los gastos de envío del artículo
                    double gastosEnvioArticuloNuevo = 0;
                    boolean gastosEnvioValidos = false;
                    while (!gastosEnvioValidos) {
                        try {
                            System.out.print("Indica los gastos de envío del artículo: ");
                            gastosEnvioArticuloNuevo = scanner.nextDouble();
                            if (gastosEnvioArticuloNuevo >= 0) {
                                gastosEnvioValidos = true;
                            } else {
                                System.out.println("Los gastos de envío deben ser un número positivo.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, ingresa un valor numérico válido.");
                            scanner.nextLine(); // Limpiar el buffer del scanner
                        }
                    }

                    // Ingresar el tiempo de preparación del artículo
                    int tiempoPreparacionMinutosArticuloNuevo = 0;
                    boolean tiempoPreparacionValido = false;
                    while (!tiempoPreparacionValido) {
                        try {
                            System.out.print("Indica el tiempo de preparación del artículo (min): ");
                            tiempoPreparacionMinutosArticuloNuevo = scanner.nextInt();
                            if (tiempoPreparacionMinutosArticuloNuevo >= 0) {
                                tiempoPreparacionValido = true;
                            } else {
                                System.out.println("El tiempo de preparación debe ser un número positivo.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, ingresa un valor numérico válido.");
                            scanner.nextLine(); // Limpiar el buffer del scanner
                        }
                    }
                    controlador.anadirArticulo(codigoArticuloNuevo, descripcionArticuloNuevo, precioVentaArticuloNuevo, gastosEnvioArticuloNuevo, tiempoPreparacionMinutosArticuloNuevo);
                    break;

                case 2:
                    gestionArticulosMenu();
            }
        } 
        while (opcion != 0);
   
        }
        /*-------------------ELIMINAR--------------------------------------ARTICULO--------------*/


        public void EliminarArticulo() {
            try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name())) {
                String opcion;

                // Utilizar un bucle while para permitir múltiples eliminaciones
                while (true) {
                    // Ingresar el código del artículo
                    System.out.print("Indica el código del artículo (o '0' para salir): ");
                    opcion = scanner.nextLine();

                    if (opcion.equals("0")) {
                        // Salir del bucle si el usuario ingresa '0'
                        gestionArticulosMenu();
                    }

                    // Obtener el artículo por código
                    Articulo art = controlador.buscarArticuloPorCodigo(opcion);

                    if (art != null) {
                        // Eliminar el artículo
                        controlador.eliminarArticulo(art); // Ajustar según tu lógica de eliminación
                        System.out.println("Artículo eliminado exitosamente.");
                    } else {
                        System.out.println("No se ha encontrado un artículo con ese código.");
                    }
                }
            } catch (SQLException | ClassNotFoundException | DAOException ex) {
                ex.printStackTrace();
                // Manejar la excepción según tus necesidades
            }
        }
    


        /*-------------------MODIFICAR--------------------------------------ARTICULO--------------*/
        
       public void modificarArticulo() throws ClassNotFoundException, DAOException, SQLException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        Articulo art = new Articulo();
        art=null;

        while (art == null) {
            // Ingresar el código del artículo
            System.out.print("Indica el código del artículo a modificar: ");
            String codigoArticulo = scanner.nextLine();

            // Buscar el artículo por su código
            art = controlador.buscarArticuloPorCodigo(codigoArticulo);
            if (art == null) {
               System.out.println("El artículo con código " + codigoArticulo + " no existe. Intenta de nuevo.");
            }
       }
        // Verificar si se encontró el artículo
        if (art != null) {
                    // Mostrar la información actual del artículo
                    System.out.println("Información actual del artículo:");
                    System.out.println(art.toString());
                    System.out.print("Nuevo código (dejar en blanco para mantener el valor actual): ");
                    String nuevoCodigo = solicitarNoVacio(scanner, art.getCodigo());
                    // Solicitar nuevos valores para los campos que deseas modificar
                    System.out.print("Nuevo precio de venta (dejar en blanco para mantener el valor actual): ");
                    Double nuevoPrecioVenta = solicitarDouble(scanner, art.getPrecioVenta());

                    System.out.print("Nuevo gasto de envío (dejar en blanco para mantener el valor actual): ");
                    Double nuevoGastoEnvio = solicitarDouble(scanner, art.getGastosEnvio());

                    System.out.print("Nuevo tiempo de preparación (minutos) (dejar en blanco para mantener el valor actual): ");
                    Integer nuevoTiempoPreparacion = solicitarInt(scanner, art.getTiempoPreparacionMinutos());

                    System.out.print("Nueva descripción (dejar en blanco para mantener el valor actual): ");
                    String nuevaDescripcion = solicitarNoVacio(scanner, art.getDescripcion());

                    // Actualizar el artículo con los nuevos valores
                    
                    art.setCodigo(nuevoCodigo);
                    art.setPrecioVenta(nuevoPrecioVenta);
                    art.setGastosEnvio(nuevoGastoEnvio);
                    art.setTiempoPreparacionMinutos(nuevoTiempoPreparacion);
                    art.setDescripcion(nuevaDescripcion);

                    // Llamar al controlador para actualizar el artículo en la base de datos
                    controlador.actualizarArticulo(art);

                    System.out.println("Artículo modificado exitosamente.");
                } else {
                    System.out.println("No se ha encontrado un artículo con ese código.");
                }
}

        // Métodos de utilidad para solicitar valores numéricos válidos, permitiendo mantener el valor actual si no se ingresa nada
        // PARA NO EXTENDER MUCHO CÓDIGO LÓGICO.--------------------------------------------------------------------------------       
        private Double solicitarDouble(Scanner scanner, Double valorActual) {
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    return valorActual;
                }

                try {
                    return Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.print("Por favor, ingresa un valor numérico válido o deja en blanco para mantener el valor actual: ");
                }
            }
        }
        private Integer solicitarInt(Scanner scanner, Integer valorActual) {
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    return valorActual;
                }

                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.print("Por favor, ingresa un valor entero válido o deja en blanco para mantener el valor actual: ");
                }
            }
        }
        private String solicitarNoVacio(Scanner scanner, String valorActual) {
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    return valorActual;
                } else {
                    return input;
                }
            }
        }
/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*---------------------------------------FIN ARTÍCULO----------------------------------------------------------------------------------*/
/*-------------------------------------------------------------------------------------------------------------------------------------*/
        
        //GESTION CLIENTES--------------------------------------------------------------------------
        void gestionClientesMenu() throws DAOException, SQLException, ClassNotFoundException {
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
                       try {
                                List<Cliente> lista = controlador.obtenerListaClientes();
                                for (Cliente a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        break;
                    case '3':
                        try {
                                List<Cliente> lista = controlador.obtenerListaClientesEstandar();
                                for (Cliente a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        break;

                    case '4':
                       try {
                                List<Cliente> lista = controlador.obtenerListaClientesPremium();
                                for (Cliente a : lista) {
                                    System.out.println(a.toString());
                                }
                            } catch (DAOException | SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        break;
                    case '0':
                        inicio();
                        break;
                }
            } while (!salir);
        }
        public void añadirCliente() throws DAOException, SQLException, ClassNotFoundException{
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Cliente Estándar");
            System.out.println("2. Cliente Premium");
            System.out.println("3. Atrás");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    String tipoClienteNuevo = "estandar"; 
                    
                    
                    System.out.print("Indica el nombre del cliente: ");
                    scanner.nextLine(); // Consumir la nueva línea restante
                    String nombreClienteNuevo = scanner.nextLine();
                    System.out.print("Indica el email del cliente: ");
                    String emailClienteNuevo = scanner.nextLine();
                    System.out.print("Indica la direccion del cliente: ");
                    String direccionClienteNuevo = scanner.nextLine();
                    System.out.print("Indica el nif del cliente: ");
                    String nifClienteNuevo = scanner.nextLine();
 
                    controlador.agregarCliente(tipoClienteNuevo, emailClienteNuevo, nombreClienteNuevo, direccionClienteNuevo, nifClienteNuevo);
                    break;
                case 2:
                    
                    String tipoClienteNuevoPremium = "premium"; 
                    
                    System.out.print("Indica el nombre del cliente: ");
                    scanner.nextLine(); // Consumir la nueva línea restante
                    String nombreClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica el email del cliente: ");
                    String emailClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica la direccion del cliente: ");
                    String direccionClienteNuevoPremium = scanner.nextLine();
                    System.out.print("Indica el nif del cliente: ");
                    String nifClienteNuevoPremium = scanner.nextLine();
 
                    controlador.agregarCliente(tipoClienteNuevoPremium, emailClienteNuevoPremium, nombreClienteNuevoPremium, direccionClienteNuevoPremium, nifClienteNuevoPremium);
                    break;
                case 3:
                    gestionClientesMenu();
            }
        } 
        while (opcion != 0);
        // GESTION PEDIDOS
        }
        // GESTION PEDIDOS
        void gestionPedidosMenu() throws DAOException, SQLException, ClassNotFoundException {
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
                        ///controlador.eliminarPedido(numeroPedidoEliminar);
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

        
        
        
        
        
        
        
        
        
        
        
        public void añadirPedido() throws DAOException, SQLException, ClassNotFoundException {
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

                        int clienteExistente = controlador.obtenerClientePedidoNuevo(emailClientePedidoNuevo);
                         System.out.print(clienteExistente + "\n");
                        if (clienteExistente != 0) {
                            añadirPedido2(clienteExistente); // Pasa el objeto Cliente existente a añadirPedido2
                        } else {
                            System.out.println("El cliente no existe, tienes que añadirlo ");
                            añadirCliente();
                        }
                        break;
                    case 2:
                        gestionClientesMenu();
                        break;
                }
            } while (opcion != 0);
        }
        public void añadirPedido2(int clienteExistente) throws DAOException, SQLException, ClassNotFoundException {
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
                        // Obtén el idCliente del cliente existente
                        int idCliente = clienteExistente;
                        scanner.nextLine();
                        System.out.print(idCliente + "\n");
                        System.out.print("Indica el código del artículo: ");
                        String codigoArticuloPedidoNuevo = scanner.nextLine();            
                        System.out.print("Indica la cantidad: ");
                        int cantidadPedidoNuevo = scanner.nextInt();
                        Date fechaPedidoNuevo = new Date();
                         // Utiliza el objeto Cliente existente y el idCliente para crear el pedido
                        if (clienteExistente != 0) {
                            // Obtén el objeto Articulo de la base de datos utilizando el código
                            String idClaseArticulo = controlador.buscarArticuloPorCodigo2(codigoArticuloPedidoNuevo);

                            // Verifica si el artículo se encontró en la base de datos
                            if (idClaseArticulo != null) {
                                // Crea el pedido utilizando el cliente, artículo, idCliente y otros datos
                                Pedido pedidoNuevo = new Pedido(numeroPedidoNuevo, idCliente, idClaseArticulo, cantidadPedidoNuevo, fechaPedidoNuevo);
                                controlador.añadirPedido(pedidoNuevo);
                            } else {
                                System.out.println("Artículo no encontrado.");
                            }
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                        break;
                    case 2:
                        gestionPedidosMenu();
                        break;
                }
            } while (opcion != 0);
        }
        
        
        void obtenerPedidosMenu() throws DAOException, SQLException, ClassNotFoundException {
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
                        ///controlador.obtenerPedidosPendientes(emailClientePendientes);
                        break;
                    case '2':
                        System.out.print("Indica el email del cliente: ");
                        String emailClienteEnviados = scanner.nextLine();
                        ///controlador.obtenerPedidosEnviados(emailClienteEnviados);
                        break;
                    case '3':
                        gestionPedidosMenu();
                        break;
                }
            } while (!salir);
        
        }
}
    
    