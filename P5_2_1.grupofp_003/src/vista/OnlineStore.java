/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import modelo.ArticuloDao;
import modelo.DAOException;
import modelo.MysqlArticuloDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class OnlineStore {
     
    public static void main(String[] args)throws DAOException, SQLException, ClassNotFoundException {
        
     
    GestionOS gestion = new GestionOS();
    gestion.inicio();
    }
 }