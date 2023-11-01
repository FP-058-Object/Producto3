/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */
public class Articulo {
    private String codigo;
    private String descripcion;
    private double precioVenta;
    private double gastosEnvio;
    private int tiempoPreparacionMinutos;

    public Articulo(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacionMinutos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacionMinutos = tiempoPreparacionMinutos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoPreparacionMinutos() {
        return tiempoPreparacionMinutos;
    }

    public void setTiempoPreparacionMinutos(int tiempoPreparacionMinutos) {
        this.tiempoPreparacionMinutos = tiempoPreparacionMinutos;
    }


    @Override
    public String toString() {
        return "Articulo [Codigo: " + codigo + ", Descripcion: " + descripcion + ", Precio de Venta: " + precioVenta
                + ", Gastos de Envio: " + gastosEnvio + ", Tiempo de Preparacion: " + tiempoPreparacionMinutos + " minutos]";
    }
}
