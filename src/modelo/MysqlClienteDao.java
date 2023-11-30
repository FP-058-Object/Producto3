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
 *
 * @author Israel
 */
public class MysqlClienteDao implements ClienteDao{
    //public Cliente(String email, String nombre, String domicilio, String nif)
    final String INSERT = "INSERT INTO cliente (email, nombre, domicilio, nif, tipoCliente, calcAnual, descuentoEnv) VALUES(?,?,?,?,?,?,?)";

    final String UPDATE = "UPDATE cliente SET idCliente= ?,email= ?, nombre= ?, domicilio= ?,nif= ? WHERE idCliente = ?";
    final String DELETE = "DELETE FROM cliente WHERE idCliente = ?";
    final String GETALL = "SELECT * FROM cliente";
    final String GETONEE = "SELECT * FROM cliente WHERE tipoCliente = 'estandar'";
    final String GETONEP = "SELECT * FROM cliente WHERE tipoCliente = 'premium'";
    private Connection conn;

    public MysqlClienteDao(Connection conn) {
        this.conn = conn;
    }

public void insertar(Cliente a) throws DAOException {
    PreparedStatement stament = null;
    try {
        stament = conn.prepareStatement(INSERT);
        stament.setString(1, a.getEmail());
        stament.setString(2, a.getNombre());
        stament.setString(3, a.getDomicilio());
        stament.setString(4, a.getNif());
        stament.setString(5, a.getTipoCliente());

        // Si el tipo de cliente es 'estandar', establece calcAnual y descuentoEnv como null
        if ("estandar".equals(a.getTipoCliente())) {
            stament.setNull(6, java.sql.Types.FLOAT);
            stament.setNull(7, java.sql.Types.FLOAT);
        } else if ("premium".equals(a.getTipoCliente())) {
            // Si el tipo de cliente es 'premium', establece calcAnual y descuentoEnv como 1
            stament.setFloat(6, 30f); // Puedes ajustar este valor según sea necesario
            stament.setFloat(7, 0.2f); // Puedes ajustar este valor según sea necesario
        }

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
                throw new DAOException("Es null", ex);
            }
        }
    }
}

    private Cliente convertir(ResultSet rs) throws DAOException, SQLException {
        
        
        int idCliente = rs.getInt("idCliente");
        String email = rs.getString("email");
        String nombre = rs.getString("nombre");
        String domicilio = rs.getString("domicilio");
        String nif = rs.getString("nif");
        String tipoCliente = rs.getString("tipoCliente");
        float calcAnual = rs.getFloat("calcAnual");
        float descuentoEnv = rs.getFloat("descuentoEnv");

        Cliente cliente = new Cliente(tipoCliente, email, nombre, domicilio, nif);
        cliente.setIdCliente(idCliente);
        cliente.setTipoCliente(tipoCliente);
        cliente.setCalcAnual(calcAnual);
        cliente.setDescuentoEnv(descuentoEnv);

        return cliente;
        
        
    }


    @Override
    public void modificar(Cliente a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Cliente a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> getListTodos() throws DAOException {
        
        PreparedStatement stament = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stament = conn.prepareStatement(GETALL);
            rs = stament.executeQuery();

            while (rs.next()) {
                clientes.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL", ex);
                }
            }
            if (stament != null) {
                try {
                    stament.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL", ex);
                }
            }
        }

        return clientes;
    }
    
    @Override
    public List<Cliente> getListTodosEstandar(){
        
        PreparedStatement stament = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stament = conn.prepareStatement(GETONEE);
            rs = stament.executeQuery();

            while (rs.next()) {
                clientes.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                throw new DAOException("Error en SQL", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (DAOException ex) {
            Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    try {
                        throw new DAOException("Error SQL", ex);
                    } catch (DAOException ex1) {
                        Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            if (stament != null) {
                try {
                    stament.close();
                } catch (SQLException ex) {
                    try {
                        throw new DAOException("Error SQL", ex);
                    } catch (DAOException ex1) {
                        Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }

        return clientes;
    }
    
    @Override
    public List<Cliente> getListTodosPremium(){
        
        
        PreparedStatement stament = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stament = conn.prepareStatement(GETONEP);
            rs = stament.executeQuery();

            while (rs.next()) {
                clientes.add(convertir(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                throw new DAOException("Error en SQL", ex);
            } catch (DAOException ex1) {
                Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (DAOException ex) {
            Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    try {
                        throw new DAOException("Error SQL", ex);
                    } catch (DAOException ex1) {
                        Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
            if (stament != null) {
                try {
                    stament.close();
                } catch (SQLException ex) {
                    try {
                        throw new DAOException("Error SQL", ex);
                    } catch (DAOException ex1) {
                        Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }

        return clientes;
    }


    @Override
    public Cliente obtenerId(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
   

