package com.bennu.administrador.simulador20.modelo;

/**
 * Created by Rubén on 3/5/2016.
 */
public class RangoMinimoMaximo {
    private int id;
    private double minimo;
    private double maximo;


    public RangoMinimoMaximo(double minimo, double maximo) {
        this(minimo, maximo, 0);
    }

    public RangoMinimoMaximo(double minimo, double maximo, int id)
    {
        this.id = id;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public double getId() {
        return id;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }
}
