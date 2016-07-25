package com.bennu.administrador.simulador20.modelo;

/**
 * Created by administrador on 24/07/16.
 */
public class AddTubing extends RangoMinimoMaximo
{
    private double id;
    private double od;
    private double unitWeight;
    private double e;
    private double g;
    private double poissonRatio;
    private double drift;
    private double tension;
    private double compression;
    private double burst;
    private double collapse;
    private double torqueLimit;
    private double thermalExp;

    public AddTubing(double minimo, double maximo, double id, double od,
                     double unitWeight, double e, double g, double poissonRatio,
                     double drift, double tension, double compression,
                     double burst, double collapse, double torqueLimit, double thermalExp)
    {
        super(minimo, maximo);
        this.id = id;
        this.od = od;
        this.unitWeight = unitWeight;
        this.e = e;
        this.g = g;
        this.poissonRatio = poissonRatio;
        this.drift = drift;
        this.tension = tension;
        this.compression = compression;
        this.burst = burst;
        this.collapse = collapse;
        this.torqueLimit = torqueLimit;
        this.thermalExp = thermalExp;
    }

    public AddTubing(double minimo, double maximo, int idTabla, double id,
                     double od, double unitWeight, double e, double g,
                     double poissonRatio, double drift, double tension,
                     double compression, double burst, double collapse, double torqueLimit,
                     double thermalExp)
    {
        super(minimo, maximo, idTabla);
        this.id = id;
        this.od = od;
        this.unitWeight = unitWeight;
        this.e = e;
        this.g = g;
        this.poissonRatio = poissonRatio;
        this.drift = drift;
        this.tension = tension;
        this.compression = compression;
        this.burst = burst;
        this.collapse = collapse;
        this.torqueLimit = torqueLimit;
        this.thermalExp = thermalExp;
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

    public double getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getPoissonRatio() {
        return poissonRatio;
    }

    public void setPoissonRatio(double poissonRatio) {
        this.poissonRatio = poissonRatio;
    }

    public double getDrift() {
        return drift;
    }

    public void setDrift(double drift) {
        this.drift = drift;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public double getCompression() {
        return compression;
    }

    public void setCompression(double compression) {
        this.compression = compression;
    }

    public double getBurst() {
        return burst;
    }

    public void setBurst(double burst) {
        this.burst = burst;
    }

    public double getCollapse() {
        return collapse;
    }

    public void setCollapse(double collapse) {
        this.collapse = collapse;
    }

    public double getTorqueLimit() {
        return torqueLimit;
    }

    public void setTorqueLimit(double torqueLimit) {
        this.torqueLimit = torqueLimit;
    }

    public double getThermalExp() {
        return thermalExp;
    }

    public void setThermalExp(double thermalExp) {
        this.thermalExp = thermalExp;
    }
}
