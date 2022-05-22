/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agilproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kelvin
 */
public class Factura {

    private String identificador;
    private String detalleFactura;
    private double total = 0;
    private final int iva = 12;
    private String fecha;
    private ArrayList<Celular> listaCelular;

    public Factura(String identificador, String detalleFactura, ArrayList<Celular> listaCelular) {
        this.identificador = identificador;
        this.detalleFactura = detalleFactura;
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.fecha = format.format(today);
        this.listaCelular = listaCelular;
    }

    public void agregarListaCelulares(Celular celular) {
        this.listaCelular.add(celular);
    }

    public double calcularPrecioTotal() {
        for (int i = 0; i < this.listaCelular.size(); i++) {
            this.total += this.listaCelular.get(i).getPrecio();
        }
        return this.total;
    }

    public double calcularPrecioTotalConIva() {
        return this.total + ((this.total * this.iva) / 100);
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "Factura N:. " + identificador + "\n"
                + "Fecha de compra = " + fecha + "\n";
        for (int i = 0; i < this.listaCelular.size(); i++) {
            salida += this.listaCelular.get(i).getModelo() + "  ";
            salida += this.listaCelular.get(i).getPrecio() + "   \n";
        }
        salida += "Sumatoria de precios = $" + calcularPrecioTotal()
                + "\nIva = " + iva + " %"
                + "\nPrecio final = $" + calcularPrecioTotalConIva();
        return salida;
    }

}
