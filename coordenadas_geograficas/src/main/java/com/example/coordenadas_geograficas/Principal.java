package com.example.coordenadas_geograficas;

/**
 * Created by Dr4ckO on 16/04/2015.
 */
public class Principal {
    public static void main (String[] main){
        GeoPunto punto1 = new GeoPunto(15.45, 45.52);
        GeoPunto punto2 = new GeoPunto(5.05, 30.02);

        Double distancia = punto1.distancia(punto2);

        System.out.println("Distancia: " + distancia);
    }
}
