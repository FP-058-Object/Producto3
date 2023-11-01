/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */
public class ListaClientes extends Lista<Cliente>{
    public Cliente buscarPorEmail(String email) {
        for (Cliente cliente : obtenerLista()) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra el cliente con el correo electrónico dado
    }
}
