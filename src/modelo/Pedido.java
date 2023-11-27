/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    Articulo articulo;
    private int cantidad;
    private Date fechaHoraPedido;
    private boolean enviado;
    

    public Pedido(int numeroPedido, Cliente cliente, Articulo articulo, int cantidad, Date fechaHoraPedido) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaHoraPedido = fechaHoraPedido;
    }

    // Otros atributos y constructor
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public boolean isEnviado() {
        long tiempoTranscurrido = calcularTiempoTranscurrido(getFechaHoraPedido());
        return tiempoTranscurrido > articulo.getTiempoPreparacionMinutos();
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public boolean pedidoEnviado() {
        long tiempoTranscurrido = calcularTiempoTranscurrido(getFechaHoraPedido());
        return tiempoTranscurrido > articulo.getTiempoPreparacionMinutos();
    }


    public float precioEnvio() {
        return enviado ? 0 : (float) (articulo.getGastosEnvio() * cantidad * (1 - cliente.descuentoEnv()));
    }

    @Override
    public String toString() {
        String estadoEnvio;
        long tiempoTranscurrido = calcularTiempoTranscurrido(getFechaHoraPedido());
        if (tiempoTranscurrido > articulo.getTiempoPreparacionMinutos()){
        estadoEnvio = "Enviado";
        }
        else{
                estadoEnvio = "Pendiente de envío";
                }
    

        return "Pedido #" + numeroPedido + "\nCliente: " + cliente.toString() + "\nArtículo: " + articulo.toString()
                + "\nCantidad: " + cantidad + "\nFecha y Hora del Pedido: " + fechaHoraPedido + "\nEstado: " + estadoEnvio;
    }
    
    
    
    private long calcularTiempoTranscurrido(Date fechaPedido) {
        // Obtiene la fecha y hora actual
        Date fechaActual = new Date();

        // Convierte las fechas a objetos Calendar
        Calendar calendarPedido = Calendar.getInstance();
        calendarPedido.setTime(fechaPedido);
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(fechaActual);

        // Calcula la diferencia en milisegundos
        long diferenciaEnMilisegundos = calendarActual.getTimeInMillis() - calendarPedido.getTimeInMillis();

        // Convierte la diferencia a minutos
        long minutosTranscurridos = diferenciaEnMilisegundos / (60 * 1000);
        
        return minutosTranscurridos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.numeroPedido;
        hash = 61 * hash + Objects.hashCode(this.cliente);
        hash = 61 * hash + Objects.hashCode(this.articulo);
        hash = 61 * hash + this.cantidad;
        hash = 61 * hash + Objects.hashCode(this.fechaHoraPedido);
        hash = 61 * hash + (this.enviado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.numeroPedido != other.numeroPedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.enviado != other.enviado) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.articulo, other.articulo)) {
            return false;
        }
        return Objects.equals(this.fechaHoraPedido, other.fechaHoraPedido);
    }

}

