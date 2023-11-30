/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Objects;
/**
 *
 * @author elbob
 */

public class Cliente {
    public int idCliente;
    private String email;
    private String nombre;
    private String domicilio;
    private String nif;
    private String tipoCliente;
    private float calcAnual;
    private float descuentoEnv;

    public Cliente(String tipoCliente, String email, String nombre, String domicilio, String nif) {
        this.tipoCliente = tipoCliente;
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String tipoCliente() {
        // Proporciona la implementación concreta para el método tipoCliente
        return tipoCliente;
    }

    public float calcAnual() {
        // Proporciona la implementación concreta para el método calcAnual
        return calcAnual;
    }

    public float descuentoEnv() {
        // Proporciona la implementación concreta para el método descuentoEnv
        return descuentoEnv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;

    }

    public void setCalcAnual(float calcAnual) {
        this.calcAnual = calcAnual;
    }

    public void setDescuentoEnv(float descuentoEnv) {
        this.descuentoEnv = descuentoEnv;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public float getCalcAnual() {
        return calcAnual;
    }

    public float getDescuentoEnv() {
        return descuentoEnv;
    }

    @Override
    public String toString() {
        return "Cliente [Id Cliente: "+ idCliente + " Email: " + email + ", Nombre: " + nombre + ", Domicilio: " + domicilio + ", NIF: " + nif + "], Cuota anual: " + calcAnual() + ", Descuento: " + descuentoEnv();
    }
}
