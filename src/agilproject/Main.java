/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agilproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kelvin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCelulares listaCelulares = new ListaCelulares();
        String opcionMenuCompra;

        Celular c1 = new Celular("Redmi note 8", "Xiaomi", "1234567889",
                new Garantia("12/20/2030", "La garantia solo se aplica por "
                        + "defectos de fabrica"), 180);
        Celular c2 = new Celular("Redmi note 9", "Xiaomi", "1234567810",
                new Garantia("12/20/2030", "La garantia solo se aplica por "
                        + "defectos de fabrica"), 100);
        Celular c3 = new Celular("Redmi note 7", "Xiaomi", "1234567811",
                new Garantia("12/20/2030", "La garantia solo se aplica por "
                        + "defectos de fabrica"), 210);
        Celular c4 = new Celular("Redmi note 7", "Xiaomi", "1234567811",
                new Garantia("12/20/2030", "La garantia solo se aplica por "
                        + "defectos de fabrica"), 210);
        Celular c5= new Celular("Redmi note 8", "Xiaomi", "1234567882",
                new Garantia("12/20/2030", "La garantia solo se aplica por "
                        + "defectos de fabrica"), 180);
        listaCelulares.aniadirCelular(c4);
        listaCelulares.aniadirCelular(c1);
        listaCelulares.aniadirCelular(c2);
        listaCelulares.aniadirCelular(c3);
        listaCelulares.aniadirCelular(c5);
        Empresa empresa = new Empresa("MERCADOCELL.SA", listaCelulares);

        //CREACION DE NUEVOS CLIENTES EN LA EMPRESA (G.N)

        empresa.crearNuevoCliente();

        //PRUEBA QUE FUNCIONA LA VERIFICACION DE UNA UNICA CUENTA (G.N)
//        int prueba = 1;
//        while (prueba == 1) {
//            empresa.crearNuevoCliente();
//        }

        String modeloDeCelular;
        int cantidadCelulares;
        System.out.println(mostrarMenuDeCompra());
        System.out.print("\nIngrese la opcion: ");
        Scanner sc= new Scanner(System.in);
        opcionMenuCompra = sc.next();
        do {
            switch (opcionMenuCompra) {
                case "1":
                    empresa.mostrarCelulares();
                    System.out.print("Seleccione el celular que desea por su modelo: ");
                    modeloDeCelular = sc.nextLine();
//                    System.out.println(modeloDeCelular);
                    if (empresa.verificarExistenciaCelular(modeloDeCelular)) {
                        System.out.print("\nIngrese la cantidad de telefonos que desee comprar: ");
                        cantidadCelulares = sc.nextInt();
                        if (empresa.verificarDisponibilidadCelular(cantidadCelulares, modeloDeCelular)){
                            empresa.cambiarEstadoNoDisponible(modeloDeCelular, cantidadCelulares);
                            empresa.generarFactura();
                            System.exit(0);
                        }else{
                            System.out.println("El modelo del celular anteriormente ingresado no esta disponible");
                        }
                    }else{
                        System.out.println("El modelo del celular anteriormente ingresado no existe");
                    }
//                        if (empresa.verificarDisponibilidadCelular(imeiDeCelular)) {
//                            System.out.println(empresa.generarFactura(imeiDeCelular));
//                            System.exit(0);
//
//                        } else {
//                            System.out.println("El celular no se encuentra disponible");
//                        }
//                    } else {
//                        System.out.println("El celular no existe");
//                    }
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opcion no existe intentelo de nuevo");
                    System.out.println(mostrarMenuDeCompra());
                    opcionMenuCompra = sc.next();
            }
        }while(opcionMenuCompra.equals("1"));
        
        
        
        
        
    }
    //Menú que permite visualizar las opciones de compra hacia el comprador
    public static String mostrarMenuDeCompra(){
        return "\n\nSeleccione una de las siguientes opciones: "
                + "\n1. Comprar celular"
                + "\n2. Salir";
    }
    
    
    
    
}
