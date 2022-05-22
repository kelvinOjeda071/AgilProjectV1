package agilproject;

import java.util.ArrayList;
import java.util.Collections;

public class ListaMenuDesplegable {
    private ArrayList <MenuDeplegable> listaMenuDesplegable;

    public ListaMenuDesplegable() {
        this.listaMenuDesplegable = new ArrayList<>();
    }

    public void aniadirNuevoElementoDesplegable (MenuDeplegable menu){
        this.listaMenuDesplegable.add(menu);
    }
    // Como todos los elementos estan ingresando de forma ordenada entonces no es necesario ordenarlos

    public int buscarPorModelo(MenuDeplegable modelo){
        Collections.sort(listaMenuDesplegable, new ComparadorPorModeloListaDesplegable());
        return Collections.binarySearch(listaMenuDesplegable, modelo, new ComparadorPorModeloListaDesplegable());
    }

    public boolean estaVacio (){
        return listaMenuDesplegable.isEmpty();
    }

    public MenuDeplegable get(int i){
        return listaMenuDesplegable.get(i);
    }

    public int tamanioDeLaLista(){
        return listaMenuDesplegable.size();
    }

    public void imprimirListaDesplegable(){
        System.out.printf("|%12s|%12s|%18s|%n", "Modelos", "Cantidad", "Precio por unidad");
        for (MenuDeplegable m : listaMenuDesplegable){
            System.out.printf("|%12s|%12d|%18s|%n",m.getModelo(), m.getCantidad(), "$ "+m.getPrecio());
        }
    }

    public ArrayList<MenuDeplegable> getListaMenuDesplegable(){
        return this.listaMenuDesplegable;
    }

    public void setListaMenuDesplegable(ArrayList<MenuDeplegable> listaMenuDesplegable) {
        this.listaMenuDesplegable = listaMenuDesplegable;
    }
}
