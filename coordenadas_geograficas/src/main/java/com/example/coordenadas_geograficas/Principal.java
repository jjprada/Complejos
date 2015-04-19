package com.example.coordenadas_geograficas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Dr4ckO on 16/04/2015.
 */
public class Principal {
    public static void main (String[] main){
        complejos();
        complejosAmpliados();
        complejosLista();
        coordenadasGeograficas();
        conjuntos();
        listas();
    }

    private static void complejos() {
        Complejo z = new Complejo (-1.5, 3.0);
        Complejo w = new Complejo (-1.2, 2.4);

        z.suma(w);
        System.out.println("Complejo#1: " + z.toString());
        z.setReal(-1.5);
        z.setImaginario(3.0);
        z.suma(w.getReal(), w.getImaginario());
        System.out.println("Complejo#2: "+z.toString());
        z.setReal(-1.5);
        z.setImaginario(3.0);
        z.suma(w.getReal());
        System.out.println("Complejo#3: "+z.toString());
    }

    private static void complejosAmpliados() {
        Complejo lista[] = new Complejo[4];
        lista[0] = new Complejo(-1.5, 3.0);
        lista[1] = new Complejo(-1.2, -3.0);
        lista[2] = new ComplejoAmpliado(-1.5, 3.0);
        lista[3] = new ComplejoAmpliado(-1.2, 0);

        for (int i = 0; i < lista.length; i++) {
            System.out.println("Complejo: " + lista[i]);
            if(lista[i] instanceof ComplejoAmpliado){
                System.out.println("  esReal=" + ((ComplejoAmpliado) lista[i]).esReal());
            }
        }
    }

    private static void complejosLista() {
        Object lista[] = new Object[4];
        lista[0] = new Complejo(-1.5, 3.0);
        lista[1] = new GeoPunto(15, 20);
        lista[2] = new GeoPuntoAlt(45, 30, 28);
        lista[3] = new GeoPuntoAlt(5, 25, 1500);
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Elemento#"+i+": " + lista[i].toString());
            if((lista[i] instanceof GeoPuntoAlt) && (((GeoPuntoAlt)lista[i]).getAltura() > 1000)){
                System.out.println("    Punto Elevado!!!");
            }
        }
    }

    private static void coordenadasGeograficas() {
        GeoPunto punto1 = new GeoPunto(15.45, 45.52);
        GeoPunto punto2 = new GeoPunto(5.05, 30.02);

        Double distancia = punto1.distancia(punto2);

        System.out.println("Distancia: " + distancia);
    }

    private static void conjuntos() {
        Set<String> conjunto = new TreeSet<>();
        conjunto.add("manzana");
        conjunto.add("pera");
        conjunto.add("naranja");
        for(String s : conjunto){
            System.out.println("Ejemplo #1: " + s);
        }
        System.out.println("");

        conjunto.remove("pera");
        for(String s : conjunto){
            System.out.println("Ejemplo #2: "+s);
        }
        System.out.println("");

        conjunto.add("mondarina");
        conjunto.add("granada");
        conjunto.add("manzana");
        conjunto.add("kiwi");
        conjunto.add("pera");
        conjunto.isEmpty();
        for(String s : conjunto){
            System.out.println("Ejemplo #3: "+s);
        }
        System.out.println("");

        Set<String> conjunto2 = new TreeSet<>();
        conjunto2.add("manzana");
        conjunto2.add("pera");
        conjunto2.add("naranja");
        conjunto.removeAll(conjunto2);
        for(String s : conjunto){
            System.out.println("Ejemplo #4: "+s);
        }
        System.out.println("");
    }

    private static void listas() {
        List<Complejo> list = new ArrayList<>();
        list.add(new Complejo(1.0, 5.0));
        list.add(new Complejo(2.0, 4.2));
        list.add(new Complejo(2.0, 4.2));
        list.add(1, new Complejo(3.0, 0.0));
        for(Complejo c : list){
            System.out.println("Ejemplo #1: " + c);
        }
        System.out.println("");

        list.remove(0);
        for(Complejo c : list){
            System.out.println("Ejemplo #2: " + c);
        }
        System.out.println("");

        Complejo c = new Complejo(2.0, 4.2);
        list.add(c);
        list.add(c);
        int a = list.indexOf(c);
        int b = list.lastIndexOf(c);
        System.out.println("Ejemplo #3: " + a);
        System.out.println("Ejemplo #4: " + b);
    }

}

