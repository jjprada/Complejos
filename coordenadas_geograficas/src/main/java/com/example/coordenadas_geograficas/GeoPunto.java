package com.example.coordenadas_geograficas;

public class GeoPunto {
    // Atributos
    private double mLongitud;
    private double mLatitud;

    // Constructor
    public GeoPunto (double longitud, double latitud){
        this.mLongitud = longitud;
        this.mLatitud = latitud;
    }

    public GeoPunto (int longitud, int latitud){
        this.mLongitud = longitud;
        this.mLatitud = latitud;
    }

    // Métodos
    /** Transcribe el complejo a String.
     * @returnun String con la parte entera y la imaginaria */
    public String toString(){
        return "Longitud: " + mLongitud + " ; Latitud: " + mLatitud;
    }

    /** Aproxima la distancia entre dos coordenadas en metros.
     * @param punto Coordenada con la que comparamos
     * @return Double de la distancia entre ambas coordenadas */
    public double distancia (GeoPunto punto){
        final double RADIO_TIERRA = 6371000;        // En metros

        double difLongitud = Math.toRadians(this.mLongitud - punto.mLongitud);          // Diferencia entre la Longitud de ambos puntos en "radianes"
        double difLatitud = Math.toRadians(this.mLatitud - punto.mLatitud);             // Diferencia entre la Latitud de ambos puntos en "radianes"

        double seno2DifLongitud = Math.sin(difLongitud/2) * Math.sin(difLongitud/2);    // Seno al cuadrado de la diferencia de Longitud en "radianes"
        double seno2DifLatitud = Math.sin(difLatitud/2) * Math.sin(difLatitud/2);       // Seno al cuadrado de la diferencia de Latitud en "radianes"
        double cosenoLatitud1 = Math.cos(Math.toRadians(punto.mLatitud));               // Coseno de la Latitud 1 en "radianes"
        double cosenoLatitud2 = Math.cos(Math.toRadians(this.mLatitud));                // Coseno de la Latitud 2 en "radianes"

        // Algoritmo de "Haversine"
        double a = seno2DifLatitud + cosenoLatitud1 * cosenoLatitud2 * seno2DifLongitud;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double resultado = RADIO_TIERRA * c;
        
        return resultado;
    }

    public double getLongitud() {
        return mLongitud;
    }

    public void setLongitud(double longitud) {
        mLongitud = (int)(longitud * 1E6);
    }

    public double getLatitud() {
        return mLatitud;
    }

    public void setLatitud(double latitud) {
        mLatitud = (int)(latitud * 1E6);
    }
}
