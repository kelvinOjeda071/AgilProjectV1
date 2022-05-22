package agilproject;

import java.util.Comparator;

public class ComparadorCelulares implements Comparator<Celular> {
    @Override
    public int compare(Celular o1, Celular o2) {
        return (o1.getModelo().compareTo(o2.getModelo()));
    }
}
