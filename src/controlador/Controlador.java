/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.ArticuloDao;
import modelo.ClienteDao;
import modelo.PedidoDAO;
import modelo.DAOException;
import modelo.MysqlArticuloDao;
import modelo.MysqlClienteDao;
import modelo.MysqlPedidoDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Articulo;
import modelo.Cliente;


import modelo.Pedido;
/**
 *
 * @author Israel
 */
public class Controlador {

    private Connection conn;
  
  
    private Connection ConectarDb() throws ClassNotFoundException, SQLException
    {
        
        Conexion conect=new Conexion();
         try{
             
             return this.conn=conect.getConnection();
             }catch(Exception e){
                   e.toString();
             }
        
         return null;
    }
    
    /*------------------------------------ARTICULOS--------------------------------------------------------------------------------*/
    
    public Articulo buscarArticuloPorCodigo(String codigo) throws ClassNotFoundException, DAOException, SQLException{
        Articulo articulos = new Articulo();
         int idArticuloEncontrado=0;
        try{
              ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
              List<Articulo> lista = obtenerListaArticulos();
               for (Articulo a : lista) {
                 if (codigo.equals(a.getCodigo())) {
                     idArticuloEncontrado = a.getIdArticulo();  
                     break;  
                    }
                }
               if(idArticuloEncontrado!=0){
                    long num = (long)idArticuloEncontrado;
                    articulos = dao.obtenerId(num);
               }else{return null;}
        }catch(SQLException ex){
                throw  new DAOException("Error Sql", ex);
         }finally{
            if(this.conn !=null){
               this.conn.close();
            }
        }

        return articulos;
    }
    public List<Articulo> obtenerListaArticulos() throws DAOException, SQLException, ClassNotFoundException {
        List<Articulo> articulos = null;
       
        try {
            ArticuloDao dao = new MysqlArticuloDao(ConectarDb());
            articulos = dao.getListTodos();
            
        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (this.conn != null) {
                this.conn.close();
            }
        }

        return articulos;  // Ahora el método retorna la lista de artículos
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
    public void actualizarArticulo(Articulo articulo) throws ClassNotFoundException, DAOException, SQLException{
    
                 try{
                    ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
                    dao.modificar(articulo);
                    }catch(SQLException ex){
                       throw  new DAOException("Error Sql", ex);
                    }finally{
                    if(this.conn !=null){
                       this.conn.close();
                    }
                  }
    
    }
    public String buscarArticuloPorCodigo2(String codigo) throws ClassNotFoundException, DAOException, SQLException{

         String codigoArticuloEncontrado = null;
        try{
              ArticuloDao dao = new MysqlArticuloDao(ConectarDb()); 
              List<Articulo> lista = obtenerListaArticulos();
               for (Articulo a : lista) {
                 if (codigo.equals(a.getCodigo())) {
                     codigoArticuloEncontrado = a.getCodigo();  
                     break;  
                    }
                }
         
        }catch(SQLException ex){
                throw  new DAOException("Error Sql", ex);
         }finally{
            if(this.conn !=null){
               this.conn.close();
            }
        }

        return codigoArticuloEncontrado;
    }
    
/*----------------------------------------------------------------------FIN ARTÍCULO----------------------------------------------------------*/

    //Mostrar Clientes
    public List<Cliente> obtenerListaClientes() throws DAOException, SQLException, ClassNotFoundException {
            List<Cliente> clientes = null;

            try {
                ClienteDao dao = new MysqlClienteDao(ConectarDb());
                clientes = dao.getListTodos();

            } catch (SQLException ex) {
                throw new DAOException("Error SQL", ex);
            } finally {
                if (this.conn != null) {
                    this.conn.close();
                }
            }

            return clientes;  // Ahora el método retorna la lista de clientes
        }
    public List<Cliente> obtenerListaClientesEstandar() throws DAOException, SQLException, ClassNotFoundException {
            List<Cliente> clientes = null;

            try {
                ClienteDao dao = new MysqlClienteDao(ConectarDb());
                clientes = dao.getListTodosEstandar();

            } catch (SQLException ex) {
                throw new DAOException("Error SQL", ex);
            } finally {
                if (this.conn != null) {
                    this.conn.close();
                }
            }

            return clientes;  // Ahora el método retorna la lista de clientes
        }
    public List<Cliente> obtenerListaClientesPremium() throws DAOException, SQLException, ClassNotFoundException {
            List<Cliente> clientes = null;

            try {
                ClienteDao dao = new MysqlClienteDao(ConectarDb());
                clientes = dao.getListTodosPremium();

            } catch (SQLException ex) {
                throw new DAOException("Error SQL", ex);
            } finally {
                if (this.conn != null) {
                    this.conn.close();
                }
            }

            return clientes;  // Ahora el método retorna la lista de clientes
        }
    

    public Cliente agregarCliente(String tipoCliente, String email, String nombre, String domicilio, String nif) throws ClassNotFoundException, DAOException, SQLException{
           Cliente nuevoClienteP = new Cliente(tipoCliente, email, nombre, domicilio, nif);
           try{
                 ClienteDao dao = new MysqlClienteDao(ConectarDb()); 
                 dao.insertar(nuevoClienteP);

            }catch(SQLException ex){
               throw  new DAOException("Error Sql", ex);
            }finally{
            if(this.conn !=null){
               this.conn.close();
            }
          }
           return nuevoClienteP;
       }
    
 
    
    /*------------------------------------------------------FIN CLIENTES----------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
      /*-----------------------------------------------------------------------------------------------------------------------------*/
      /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------PEDIDOS ----------------------------------------------------------------------------------*/
    //Gestion Pedidos
    public String comprobarEmailPedidoNuevo(String email) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String emailCliente = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinestore", "root", "1212");
                String sql = "SELECT * FROM cliente WHERE email = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, email);
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Si hay un resultado, el cliente existe
                    emailCliente = rs.getString("email"); // Obtén el email del cliente
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Cerrar ResultSet, PreparedStatement y Connection
            }

            return emailCliente; // Devuelve el email del cliente si existe, o null si no existe
        }

            /*public boolean eliminarPedido (int numeroPedido){
                return datos.eliminarPedido(numeroPedido);
            }*/


     public int obtenerClientePedidoNuevo (String email) throws ClassNotFoundException, DAOException, SQLException{

        int idClienteEncontrado = 0;
        try{
              ClienteDao dao = new MysqlClienteDao(ConectarDb()); 
              List<Cliente> lista = obtenerListaClientes();
               for (Cliente a : lista) {
                 if (email.equals(a.getEmail())) {
                     idClienteEncontrado = a.getIdCliente();  
                     break;  
                    }
                }

        }catch(SQLException ex){
                throw  new DAOException("Error Sql", ex);
         }finally{
            if(this.conn !=null){
               this.conn.close();
            }
        }

        return idClienteEncontrado;
    }
     

    
    public List<Pedido> obtenerListaPedidos() throws DAOException, SQLException, ClassNotFoundException {
        List<Pedido> pedidos = null;
       
        try {
            PedidoDAO dao = new MysqlPedidoDao(ConectarDb());
            pedidos = dao.getListTodos();
            
        } catch (SQLException ex) {
            throw new DAOException("Error SQL", ex);
        } finally {
            if (this.conn != null) {
                this.conn.close();
            }
        }

        return pedidos;  // Ahora el método retorna la lista de artículos
    }        
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void añadirPedido(Pedido nuevoPedido) throws ClassNotFoundException, DAOException, SQLException {
        try {
            PedidoDAO dao = new MysqlPedidoDao(ConectarDb());
            dao.insertar(nuevoPedido);
        } catch (SQLException ex) {
            throw new DAOException("Error Sql", ex);
        } finally {
            if (this.conn != null) {
                this.conn.close();
            }
        }
    }
}

    
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/
    /*-----------------------------------------------------------------------------------------------------------------------------*/

