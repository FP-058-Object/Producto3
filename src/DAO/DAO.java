/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import modelo.Articulo;


/**
 *
 * @author Israel
 */
public interface DAO <T, K>{
    
    void insertar(T a) throws DAOException;    
    void modificar(T a)throws DAOException;
    
    void eliminar(T a)throws DAOException;
    
    List<T> getListTodos()throws DAOException;
    
     T obtenerId(K id)throws DAOException;
     
    
    
    
}
