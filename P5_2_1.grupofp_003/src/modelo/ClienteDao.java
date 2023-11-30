/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



import java.util.List;


/**
 *
 * @author Israel
 */
public interface ClienteDao extends DAO<Cliente, Long>{

    public List<Cliente> getListTodosEstandar();

    public List<Cliente> getListTodosPremium();
    
    
}
