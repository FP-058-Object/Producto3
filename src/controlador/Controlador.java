/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;
/**
 *
 * @author elbob
 */
public class Controlador {
    private Datos datos;
    
    public Controlador() {
        datos = new Datos();
    }
    // Gestion Articulos
        //Añadir Articulo
    public Articulo anadirArticulo(String codigo, String descripcion,  double precioVenta, double gastosEnvio, int tiempoPreparacionMinutos){
        return datos.añadirArticulo(codigo, descripcion,  precioVenta, gastosEnvio, tiempoPreparacionMinutos);
    }
        //Mostrar Articuos
    public ArrayList<Articulo> obtenerListaArticulos() {
        return datos.obtenerArticulos();
    }
    
    
    //Gestion Clientes
        //Añadir Clientes
    public Cliente agregarClienteEstandar(String email, String nombre, String domicilio, String nif){
        return datos.agregarClienteEstandar(email, nombre, domicilio, nif);
    }
    public Cliente agregarClientePremium(String email, String nombre, String domicilio, String nif){
        return datos.agregarClientePremium(email, nombre, domicilio, nif);
    }
        //Mostrar Clientes
    public ArrayList<Cliente> obtenerListaClientes() {
        return datos.obtenerClientes();
    }
    
    public ArrayList<Cliente> obtenerListaClientesEstandar() {
        return datos.obtenerClientesEstandar();
    }

    public ArrayList<Cliente> obtenerListaClientesPremium() {
        return datos.obtenerClientesPremium();
    }
    
    //Gestion Pedidos
    public ArrayList<Pedido> obtenerListaPedidos() {
        return datos.obtenerPedidos();
    }
    public Cliente obtenerPedidosPendientes(String email){
        return datos.buscarClientePorEmailPendiente(email);
    }
    public Cliente obtenerPedidosEnviados(String email){
        return datos.buscarClientePorEmailEnviado(email);
    }
    public boolean comprobarEmailPedidoNuevo(String email){
        return datos.comprobarEmailPedidoNuevo(email);
    }
    public boolean eliminarPedido (int numeroPedido){
        return datos.eliminarPedido(numeroPedido);
    }
    public Articulo buscarArticuloPorCodigo(int codigo){
        return datos.buscarArticuloPorCodigo(codigo);
    }
    public Cliente obtenerClientePedidoNuevo(String email){
        return datos.obtenerClientePedidoNuevo(email);
    }
    public Pedido crearPedidoNuevo(int numero, int cantidad, Date fecha, String email,int codigo){
        Cliente clientePedido = datos.obtenerClientePedidoNuevo(email);
        Articulo articuloPedido = datos.buscarArticuloPorCodigo(codigo);
        
        return datos.crearPedidoNuevo(numero ,clientePedido,articuloPedido, cantidad, fecha);
    
        
    }

 



}
