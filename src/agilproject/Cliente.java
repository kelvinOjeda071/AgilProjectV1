/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agilproject;

/**
 * @author Kelvin
 */
public class Cliente {
    private String nombre;
    private Cuenta cuenta;
    private Factura factura;

    public Cliente(String nombre, Cuenta cuenta, Factura factura) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.factura = factura;
    }

    public Cliente(String nombre, Cuenta cuentaUsuarioSinFactura) {
        this.nombre = nombre;
        this.cuenta = cuentaUsuarioSinFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Cliente\n"
                + "\n Nombre =" + nombre
                + "\n Cuenta=" + cuenta
                + "\n Factura=" + factura;
    }


}
