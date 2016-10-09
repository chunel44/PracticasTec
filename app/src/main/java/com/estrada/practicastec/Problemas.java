package com.estrada.practicastec;

/**
 * Created by estra on 29/09/2016.
 */
public class Problemas {

    public String Problema1(int Num){
        int suma = Num* (Num + 1) / 2;
        return "La suma de los " + Num + " primeros números enteros es: " + suma;
    }

    public String Problema2(Double Capital, Double Tasa, Double Periodo){
        Double monto = Capital*Math.pow((1+Tasa/100),Periodo);
        Double interes = monto - Capital;

        return "El monto total es:" +String.format("%8.2f",monto) + "\n" + "El interes a pagar es:" + String.format("%8.2f\n",interes);
    }
}
