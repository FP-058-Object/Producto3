/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 
package modelo;
import modelo.ClienteDao;
import modelo.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;
import modelo.Cliente;
/**

/**
 *
 * @author Israel
 */
public class MysqlPedidoDao implements PedidoDAO {
    
  final String INSERT = "INSERT INTO pedido(numeroPedido, idCliente, idClaseArticulo, cantidad, fechaHoraPedido) VALUES(?,?,?,?,?)";
final String UPDATE = "UPDATE pedido SET idCliente= ?, idClaseArticulo= ?, cantidad= ? , fechaHoraPedido= ? WHERE numeroPedido = ?";
final String DELETE = "DELETE FROM pedido WHERE numeroPedido = ?";
final String GETALL = "SELECT numeroPedido, idCliente, idClaseArticulo, cantidad, fechaHoraPedido FROM pedido";
final String GETONE = "SELECT numeroPedido, idCliente, idClaseArticulo, cantidad, fechaHoraPedido FROM pedido WHERE numeroPedido = ?";
    
    private Connection conn;
    
    public MysqlPedidoDao(Connection conn) {
        this.conn = conn;
    }

public void insertar(Pedido a) throws DAOException {
    PreparedStatement stament = null;
    try {
        stament = conn.prepareStatement(INSERT);
        stament.setInt(1, a.getNumeroPedido());
        stament.setInt(2, a.getidCliente()); 
        stament.setString(3, a.getidClaseArticulo());
        stament.setInt(4, a.getCantidad());
        stament.setTimestamp(5, new java.sql.Timestamp(a.getFechaHoraPedido().getTime()));

        if (stament.executeUpdate() == 0) {
            throw new DAOException("Ha habido un error al guardar el registro.");
        } else {
            System.out.println("Introducido registro en la base de datos.");
        }
    } catch (SQLException ex) {
        throw new DAOException("Error en SQL", ex);
    } finally {
        if (stament != null) {
            try {
                stament.close();
            } catch (SQLException ex) {
                throw new DAOException("Error al cerrar el PreparedStatement", ex);
            }
        }
    }
}
        
    public void modificar(Pedido a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Pedido a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedido> getListTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido obtenerId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
