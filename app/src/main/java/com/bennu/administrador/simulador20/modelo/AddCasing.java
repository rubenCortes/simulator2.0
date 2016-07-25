package com.bennu.administrador.simulador20.modelo;

/**
 * Created by administrador on 24/07/16.
 */
public class AddCasing extends RangoMinimoMaximo
{
    private double id;
    private double od;
    private double drift;
    private double burst;

    public AddCasing(double minimo, double maximo, double id, double od, double drift, double burst)
    {
        super(minimo, maximo);
        this.id = id;
        this.od = od;
        this.drift = drift;
        this.burst = burst;
    }

    public AddCasing(double minimo, double maximo, int idTabla, double id, double od, double drift, double burst)
    {
        super(minimo, maximo, idTabla);
        this.id = id;
        this.od = od;
        this.drift = drift;
        this.burst = burst;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getOd() {
        return od;
    }

    public void setOd(double od) {
        this.od = od;
    }

    public double getDrift() {
        return drift;
    }

    public void setDrift(double drift) {
        this.drift = drift;
    }

    public double getBurst() {
        return burst;
    }

    public void setBurst(double burst) {
        this.burst = burst;
    }
}
