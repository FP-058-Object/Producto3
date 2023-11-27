/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import DAO.ArticuloDao;
import DAO.DAOException;
import DAO.mysql.MysqlArticuloDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
    private Connection conn;
    //private Conexion conectar= new  Conexion();
    public Controlador() {
        datos = new Datos();
      //  this.conn=conectar.getConnection();
    }
    private Connection ConectarDb() throws ClassNotFoundException, SQLException
    {
        Connection conn = null; 
        String direccion="jdbc:mysql://localhost:3306/onlinestore_01";
        String user="root";
        String password="12345678";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return this.conn=DriverManager.getConnection(direccion,user,password);
 
    }
    
 
    // Gestion Articulos
        //Añadir Articulo
   /* public Articulo anadirArticulo(String codigo, String descripcion,  double precioVenta, double gastosEnvio, int tiempoPreparacionMinutos){
        return datos.añadirArticulo(codigo, descripcion,  precioVenta, gastosEnvio, tiempoPreparacionMinutos);
    }*/
    
        //Mostrar Articuos
    /*public ArrayList<Articulo> obtenerListaArticulos() {
        return datos.obtenerArticulos();
    }*/
    /*public Articulo buscarArticuloPorCodigo(String codigo){
        return datos.buscarArticuloPorCodigo(codigo);
    }*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    //-------------------------NUEVO CóDIGO-----------------------------------------------------------------------------------------*/
    
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------ARTICULOS--------------------------------------------------------------------------------*/
    
    public Articulo buscarArticuloPorCodigo(String codigo) throws ClassNotFoundException, DAOException, SQLException{
        Articulo articulos = new Articulo();
        try{
              ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
              
              
              
              long num = Long.parseLong(codigo);
              articulos = dao.obtenerId(num);
              System.out.println(articulos.toString());
        }catch(SQLException ex){
                throw  new DAOException("Error Sql", ex);
         }finally{
            if(this.conn !=null){
               this.conn.close();
            }
        }
        return articulos;
    }
    public void obtenerListaArticulos()throws DAOException, SQLException, ClassNotFoundException{
        try{
              ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
              List<Articulo> articulos = dao.getListTodos();
              for(Articulo a: articulos ){
               System.out.println(a.toString());
              }
         }catch(SQLException ex){
            throw  new DAOException("Error Sql", ex);
         }finally{
         if(this.conn !=null){
            this.conn.close();
         }
       }
         
    }
    public Articulo anadirArticulo(String codigo, String descripcion,  double precioVenta, double gastosEnvio, int tiempoPreparacionMinutos) throws ClassNotFoundException, DAOException, SQLException{
        Articulo nuevoArticulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacionMinutos);
        try{
              ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
              dao.insertar(nuevoArticulo);
              
         }catch(SQLException ex){
            throw  new DAOException("Error Sql", ex);
         }finally{
         if(this.conn !=null){
            this.conn.close();
         }
       }
        return nuevoArticulo;
    }
    public void eliminarArticulo(Articulo articulo) throws ClassNotFoundException, DAOException, SQLException{
    
                  try{
                    ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
                    dao.eliminar(articulo);
                   
                    
                    }catch(SQLException ex){
                       throw  new DAOException("Error Sql", ex);
                    }finally{
                    if(this.conn !=null){
                       this.conn.close();
                    }
                  }
            
    }
    
/*----------------------------------------------------------------------FIN ARTÍCULO----------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------------------------------------------------------*/
//Gestion Clientes
        //Añadir Clientes
    public Cliente agregarClienteEstandar(String email, String nombre, String domicilio, String nif){
        return datos.agregarClienteEstandar(email, nombre, domicilio, nif);
    }
    public Cliente agregarClientePremium(String email, String nombre, String domicilio, String nif){
        return datos.agregarClientePremium(email, nombre, domicilio, nif);
    }
        //Mostrar Clientes
    public ArrayList<Cliente> obtenerListaClientes() {
        return datos.obtenerClientes();
    }
    
    public ArrayList<Cliente> obtenerListaClientesEstandar() {
        return datos.obtenerClientesEstandar();
    }

    public ArrayList<Cliente> obtenerListaClientesPremium() {
        return datos.obtenerClientesPremium();
    }
    /*------------------------------------------------------FIN CLIENTES----------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
      /*-----------------------------------------------------------------------------------------------------------------------------*/
      /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------PEDIDOS ----------------------------------------------------------------------------------*/
    //Gestion Pedidos
    public ArrayList<Pedido> obtenerListaPedidos() {
        return datos.obtenerPedidos();
    }
    public Cliente obtenerPedidosPendientes(String email){
        return datos.buscarClientePorEmailPendiente(email);
    }
    public Cliente obtenerPedidosEnviados(String email){
        return datos.buscarClientePorEmailEnviado(email);
    }
    public boolean comprobarEmailPedidoNuevo(String email){
        return datos.comprobarEmailPedidoNuevo(email);
    }
    public boolean eliminarPedido (int numeroPedido){
        return datos.eliminarPedido(numeroPedido);
    }
    
    public Cliente obtenerClientePedidoNuevo(String email){
        return datos.obtenerClientePedidoNuevo(email);
    }
    public Pedido crearPedidoNuevo(int numero, int cantidad, Date fecha, String email,String codigo){
        Cliente clientePedido = datos.obtenerClientePedidoNuevo(email);
        Articulo articuloPedido = datos.buscarArticuloPorCodigo(codigo);
        return datos.crearPedidoNuevo(numero ,clientePedido,articuloPedido, cantidad, fecha);
    }
    
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
}
