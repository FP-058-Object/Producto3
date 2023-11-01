/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author elbob
 */

public class ClientePremium extends Cliente {
    public ClientePremium(String email, String nombre, String domicilio, String nif) {
        super(email, nombre, domicilio, nif);
    }

    @Override
    public String tipoCliente() {
        return "Premium";
    }

    @Override
    public float calcAnual() {
        return 30; // Cuota anual de 30 euros
    }

    @Override
    public float descuentoEnv() {
        return 0.20f; // 20% de descuento en gastos de envio
    }
    @Override
    public String toString() {
        return super.toString() + ", Cuota anual: " + calcAnual() + ", Descuento: " + descuentoEnv();
    }
}
