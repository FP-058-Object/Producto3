/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */


public class ClienteEstandar extends Cliente {
    public ClienteEstandar(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
    }

    @Override
    public String tipoCliente() {
        return "Estándar";
    }

    @Override
    public float calcAnual() {
        return 0; // No paga cuota anual
    }

    @Override
    public float descuentoEnv() {
        return 0; // Sin descuento en gastos de envío
    }
    @Override
    public String toString() {
        return super.toString() + ", Cuota anual: " + calcAnual() + ", Descuento: " + descuentoEnv();
    }
}
