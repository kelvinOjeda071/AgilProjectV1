package agilproject;

import java.util.Comparator;

public class ComparadorPorModeloListaDesplegable implements Comparator<MenuDeplegable> {


    @Override
    public int compare(MenuDeplegable o1, MenuDeplegable o2) {
        return (o1.getModelo().compareTo(o2.getModelo()));
    }
}
