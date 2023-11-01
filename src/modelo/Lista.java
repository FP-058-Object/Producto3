/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author elbob
 */
public class Lista<T> {
    protected ArrayList<T> lista;
    
    public Lista(){
        lista = new ArrayList<>();
    }
    public int getSize(){
        
        return 0;
        
    }
    public void agregar(T t){
        lista.add(t);
    }
    
    public T getAt(int position){
        
        return null;
        
    }
    public void eliminar(T elemento) {
        lista.remove(elemento);
    }
    public boolean isEmpty(){
        
        return false;
        
    }
    public ArrayList<T> obtenerLista() {
    for (T elemento : lista) {
            System.out.println(elemento.toString());
        }
    return lista;
    }
    
    public ArrayList<T> obtenerDatosLista() {
    return lista;
    }
}
