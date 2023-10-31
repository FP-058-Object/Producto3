/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Scanner;

/**
 *
 * @author elbob
 */
public class ListaArticulos extends Lista<Articulo>{
   
    
    
    
    public Articulo buscarPorCodigo(String codigo) {
        
        for (Articulo articulo : obtenerLista()) {
            if (articulo.getCodigo().equals(codigo)) {
                return articulo;
            }
        }
        return null; // Retorna null si no se encuentra el artículo con el código dado
    }
    
   public void mostrarArticulo(){
     
          for (Articulo articulo : obtenerLista()) {
               System.out.print(articulo.toString());
               System.out.print("\n");
            }
       
   
   
   } 
    
}
