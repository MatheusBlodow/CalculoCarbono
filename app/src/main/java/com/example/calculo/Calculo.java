package com.example.calculo;

public class Calculo {

    private double mos;
    private double adicaoKgHaAnoText;
    private double conta1;
    private double conta2;
    private double conta3;

    public double getConta1() {
        return conta1;
    }

    public double getConta2() {
        return conta2;
    }

    public double getConta3() {
        return conta3;
    }

    public void setMos(double mos) {
        this.mos = mos;
    }

    public void setAdicaoKgHaAnoText(double adicaoKgHaAnoText) {
        this.adicaoKgHaAnoText = adicaoKgHaAnoText;
    }

    protected void Calcular(){
        conta1 = 2400 * (mos / 100);
        conta2 = conta1 / 1.724;
        conta3 = conta2 / (adicaoKgHaAnoText / 1000);
    }

}
