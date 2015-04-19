package com.example.coordenadas_geograficas;

/**
 * Created by Dr4ckO on 17/04/2015.
 */
public class GeoPuntoAlt extends GeoPunto {
    private double altura;

    public GeoPuntoAlt(double longitud, double latitud, double altura){
        super(longitud, latitud);
        this.altura = altura;
    }

    public double distancia (GeoPuntoAlt punto){
        double distanciaAnterior = super.distancia(punto);
        double dAlt = this.altura - punto.altura;
        double distanciaNueva = Math.sqrt((distanciaAnterior*distanciaAnterior)+(dAlt*dAlt));

        return distanciaNueva;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return super.toString() + " ; Altura: " + altura;
    }
}
