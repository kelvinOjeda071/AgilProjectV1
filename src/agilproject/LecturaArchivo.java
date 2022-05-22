package agilproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LecturaArchivo {
    /*
     * El metodo obtenerCuentas devuelve un arraylist de hashmaps en donde el indice representa un hashmap
     * que contiene la informacion del cliente con sus respectivas claves como: nombre, usuario, contrasena
     */
    public ArrayList obtenerCuentas(String direccionDelArchivo) {
        ArrayList<HashMap> informacionCliente = new ArrayList<HashMap>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccionDelArchivo));
            //String txtTemp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                HashMap<String, String> listaDeClientes = new HashMap<String, String>();
                //txtTemp += bfRead + "\n";
                String[] res = bfRead.split("[,]", 0);
                listaDeClientes.put("nombre", res[0]);
                listaDeClientes.put("usuario", res[1]);
                listaDeClientes.put("contrasena", res[2]);
                informacionCliente.add((listaDeClientes));
            }
            //txt = txtTemp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return informacionCliente;
    }


}
