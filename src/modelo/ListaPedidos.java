/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */
public class ListaPedidos extends Lista<Pedido>{
   
    public Pedido buscarPorNumero(int numeroPedido) {
        for (Pedido pedido : obtenerLista()) {
            if (pedido.getNumeroPedido() == numeroPedido) {
                return pedido;
            }
        }
        return null; // Retorna null si no se encuentra el pedido con el número dado
    }
    /**
     * Para sumar numero nuevo
     * @return 
     */
     public int contadorDePedidos(){
          int num=0;
          for (Pedido pedido : obtenerLista()) {
                num += 1;
          }
         return num;
    }
     
     /**
      * Funcion para mostrar pedidos
      */
    public void mostrarPedidos(){
     
          for (Pedido pedidos : obtenerLista()) {
               System.out.print(pedidos.toString());
               System.out.print("\n");
            }
       
   
   
   } 
}
