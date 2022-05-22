/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agilproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kelvin
 */
public class Empresa {
    private String nombre;
    private ListaCelulares listaCelularesEmpresa;
    //EMPRESA TIENE CLIENTES Y LOS CLIENTES TIENEN CUENTAS
    private ArrayList<Cliente> listaDeClientes;
    ArrayList <Celular> listaCelularesComprados = new ArrayList<>();

    public Empresa(String nombre, ListaCelulares listaCelularesEmpresa) {
        this.nombre = nombre;
        this.listaCelularesEmpresa = listaCelularesEmpresa;
        this.listaDeClientes = new ArrayList<>();
    }

    public void mostrarCelulares() {
        String salida = "";
        salida += "Bienvenido a la empresa " + this.nombre
                + "\nA continuacion te ofrecemos nuestra lista de telefonos "
                + "celulares";

        System.out.println(salida);
        listaCelularesEmpresa.crearArrayListDeModelos();
        listaCelularesEmpresa.delegarLaCantidadPorModelo();
        listaCelularesEmpresa.imprimirPorConsolaElementosListaDeMenu();
    }

    public boolean verificarExistenciaCelular(String modelo) {
        return listaCelularesEmpresa.verificarExistenciaCelularesMenuDesplegable(modelo);
    }

    public boolean verificarDisponibilidadCelular(int cantidad, String modelo) {
        return listaCelularesEmpresa.verificarDisponibilidadMenuDesplegable(cantidad, modelo);
    }

    public void cambiarEstadoNoDisponible(String modelo, int cantidad) {

        int cantidadIndisponible = 0;
        for (int i = 0; i < listaCelularesEmpresa.tamanioLista(); i++) {
            if (listaCelularesEmpresa.get(i).getModelo().equals(modelo) && cantidadIndisponible < cantidad) {
                this.listaCelularesEmpresa.get(i).setEstado("No disponible");
                cantidadIndisponible++;
                listaCelularesComprados.add(listaCelularesEmpresa.get(i));
            }
        }
        for( Celular c1: listaCelularesComprados){
            System.out.println(c1);
        }
    }

//    public int retornarNumeroCelular(String codigoImei) {
//        int numeroCelular = -1;
//        for (int i = 0; i < listaCelularesEmpresa.size(); i++) {
//            if (listaCelularesEmpresa.get(i).getCodigoImei().equals(codigoImei)) {
//                numeroCelular = i;
//            }
//        }
//        return numeroCelular;
//    }

    public void generarFactura() {
        String salida = "";
        salida += ("Se ha realizado la compra con exito");
        salida += ("\nAcontinuacion se presenta su factura");
        System.out.println(salida);
        Factura factura = new Factura("1", "Compra de celulares ", listaCelularesComprados);
        salida += factura;
        System.out.println(salida);

    }
    //LA EMPRESA CREARA UN NUEVO CLIENTE SIN UNA FACTURA PERO CON UNA CUENTA UNICA (G.N)

    public Cliente crearNuevoCliente() {
        Scanner entradaDeDatos = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = entradaDeDatos.next();
        System.out.print("Cree un usuario: ");
        String nombreDeUsuario = entradaDeDatos.next();
        System.out.print("Cree una contrasena: ");
        String contrasena = entradaDeDatos.next();
        //Crear nuevo cliente
        Cuenta nuevaCuenta = new Cuenta(nombreDeUsuario, contrasena);
        Cliente nuevoCliente = new Cliente(nombreCliente, nuevaCuenta);

        //TODO: Verificar que no exista una cuenta con el mismo usuario
        if (!verificarExistenciaDeCuenta(nuevaCuenta)) {
            this.listaDeClientes.add(nuevoCliente);
            System.out.println("USUARIO CREADO CON EXITO!!");
        } else {
            System.out.println("ESTE USUARIO YA EXISTE CREAR OTRO USUARIO!!!");
            crearNuevoCliente();
        }
        //System.out.println(listaDeClientes);
        return nuevoCliente;
    }

    private boolean verificarExistenciaDeCuenta(Cuenta nuevaCuenta) {
        boolean usuarioEncontrado = false;
        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if (this.listaDeClientes.get(i).getCuenta().getUsuario().equals(nuevaCuenta.getUsuario())) {
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }


}
