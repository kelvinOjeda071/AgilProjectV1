/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agilproject;

/**
 *
 * @author Kelvin
 */
public class Celular {
    private String modelo;
    private String nombreMarca;
    private String codigoImei;
    private Garantia garantia;
    private float precio;
    private String estado;

    public Celular(String modelo, String nombreMarca, String codigoImei, Garantia garantia, float precio) {
        this.modelo = modelo;
        this.nombreMarca = nombreMarca;
        this.codigoImei = codigoImei;
        this.garantia = garantia;
        this.precio = precio;
        this.estado = "Disponible";
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getCodigoImei() {
        return codigoImei;
    }

    public void setCodigoImei(String codigoImei) {
        this.codigoImei = codigoImei;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    @Override
    public String toString() {
        return "Modelo = " + modelo 
                + "\nMarca = " + nombreMarca 
                + "\nCodigo Imei = " + codigoImei
                + "\n" + garantia 
                + "\nPrecio = $" + precio 
                + "\nEstado = " + estado +"\n";
    }

    
    
    
}
