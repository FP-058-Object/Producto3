/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;
import modelo.Articulo;
import DAO.ArticuloDao;
import DAO.DAOException;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Israel
 */
public class MysqlArticuloDao implements ArticuloDao{
    
    final String INSERT = "INSERT INTO articulo(codigo, descripcion, precioVenta,gastosEnvio, tiempoPreparacionMinutos) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE articulo SET codigo= ?, descripcion= ?, precioVenta= ? ,gastosEnvio= ?, tiempoPreparacionMinutos= ?";
    final String DELETE = "DELETE FROM articulo WHERE idArticulo = ?";
    final String GETALL = "SELECT  idArticulo,codigo, descripcion, precioVenta,gastosEnvio, tiempoPreparacionMinutos FROM articulo";
    final String GETONE = "SELECT  idArticulo,codigo, descripcion, precioVenta,gastosEnvio, tiempoPreparacionMinutos FROM articulo WHERE idArticulo = ?";
    
    private Connection conn;

    public MysqlArticuloDao(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertar( Articulo a) throws DAOException{
       PreparedStatement stament = null;
       try{
           stament = conn.prepareStatement(INSERT);
           stament.setString(1,a.getCodigo());
           stament.setString(2, a.getDescripcion());
           stament.setDouble(3,a.getPrecioVenta());
           stament.setDouble(4,a.getGastosEnvio());
           stament.setInt(5,a.getTiempoPreparacionMinutos());
           if(stament.executeUpdate()==0){
              throw new DAOException("Ha habido un error al guardar el registro.");
           }
           else{
                 System.out.println("Itroducido registro en la base de datos.");
           
           }
       }catch(SQLException ex){
              throw new DAOException("Error en SQl",ex);
        }finally{
          if(stament !=null){
              try{
                  stament.close();
              }catch(SQLException ex){
                throw new DAOException("Es null",ex);
              }
             
            } 
          
        }
    
    
    }

    @Override
    public void modificar(Articulo a)throws DAOException {
        PreparedStatement stament = null;
       try{
           stament = conn.prepareStatement(UPDATE);
           stament.setString(1,a.getCodigo());
           stament.setString(2, a.getDescripcion());
           stament.setDouble(3,a.getPrecioVenta());
           stament.setDouble(3,a.getGastosEnvio());
           stament.setInt(5,a.getTiempoPreparacionMinutos());
           if(stament.executeUpdate()==0){
              throw new DAOException("Ha habido un error al guardar el registro.");
           }
           else {
             System.out.println("Modificado el registro he introducido en la base de datos");
           
           }
       }catch(SQLException ex){
              throw new DAOException("Error en SQl",ex);
        }finally{
          if(stament !=null){
              try{
                  stament.close();
              }catch(SQLException ex){
                throw new DAOException("Es null",ex);
              }
             
            } 
          
        }
    
        
    }

    @Override
    public void eliminar(Articulo a)throws DAOException{
       PreparedStatement stament = null;
       try{
           stament = conn.prepareStatement(DELETE);
           stament.setLong(1, Long.valueOf(a.getCodigo()));
           
           if(stament.executeUpdate()==0){
              throw new DAOException("Ha habido un error al eliminar el registro el registro.");
           }
       }catch(SQLException ex){
              throw new DAOException("Error en SQl",ex);
        }finally{
          if(stament !=null){
              try{
                  stament.close();
              }catch(SQLException ex){
                throw new DAOException("Es null la conexión",ex);
              }
             
            } 
          
        }
    }

    
    private Articulo convertir(ResultSet rs) throws DAOException, SQLException{
       
        String codigo = rs.getString("codigo"); 
        String descripcion = rs.getString("descripcion");
        double precioVenta = rs.getDouble("precioVenta"); 
        double gastosEnvio = rs.getDouble("gastosEnvio");
        int tiempoPreparacionMinutos = rs.getInt("tiempoPreparacionMinutos");
        Articulo art = new Articulo(codigo,descripcion,precioVenta,gastosEnvio,tiempoPreparacionMinutos);
        //art.getIdArticulo("idArticulo");
        return art ;
    
    }
    @Override
    public List<Articulo> getListTodos() throws DAOException {
          PreparedStatement stament = null;
          ResultSet rs= null;
          List<Articulo> articulos= new ArrayList<>();
          try{
              
             stament = conn.prepareStatement(GETALL);
             rs=stament.executeQuery();
             while(rs.next()){
                articulos.add(convertir(rs));
             }
          }catch(SQLException ex){
              ex.printStackTrace(); 
              throw new DAOException("Error en SQl",ex);
          }finally{
                if(rs !=null){
                   try{
                       rs.close();
                   }catch(SQLException ex){
                     throw new DAOException("Error Sql", ex);
                   }
                }
                if(stament != null){
                  try{
                    stament.close();
                  }catch(SQLException ex){
                   throw new DAOException("Error Sql", ex);
                  }
                }
          }
     return articulos;
    }    
    //-----------------------------------------------------------//
    @Override
    public Articulo obtenerId(Long id) throws DAOException {
          PreparedStatement stament =null;
          ResultSet rs=null;
          Articulo a=null;
          try{
             stament =conn.prepareStatement(GETONE);
             stament.setLong(1, id);
             rs=stament.executeQuery();
             if(rs.next()){
                a=convertir(rs);
             }else{
             throw new DAOException("No se ha encontrado ese registro");
             }
          }catch(SQLException ex){
               throw new DAOException("Error en SQl",ex);
          }finally{
                if(rs !=null){
                   try{
                       rs.close();
                   }catch(SQLException ex){
                     throw new DAOException("Error Sql", ex);
                   }
                }
                if(stament != null){
                  try{
                    stament.close();
                  }catch(SQLException ex){
                   throw new DAOException("Error Sql", ex);
                  }
                }
          }
     return a;
    }

    
}
