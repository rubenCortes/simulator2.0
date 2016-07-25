package com.bennu.administrador.simulador20.modelo;

/**
 * Created by Rubén on 3/5/2016.
 */
public class RangoMinimoMaximo {
    private int idPrimario;
    private double minimo;
    private double maximo;


    public RangoMinimoMaximo(double minimo, double maximo) {
        this(minimo, maximo, 0);
    }

    public RangoMinimoMaximo(double minimo, double maximo, int idPrimario) {
        this.idPrimario = idPrimario;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public double getIdPrimario() {
        return idPrimario;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }


    public void setIdPrimario(int idPrimario) {
        this.idPrimario = idPrimario;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }
}
