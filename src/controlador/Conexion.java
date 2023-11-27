/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Israel
 */
public class Conexion {
    Connection con;
   public Connection getConnection(){
       String direccion="jdbc:mysql://localhost:3306/onlinestore";
       String user="root";
       String password="12345678";
     try{
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(direccion,user,password);
     }catch(Exception e){
        e.toString();
     }
     
   
        return con;
   } 
}
