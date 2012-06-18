/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calfin;

import java.text.DecimalFormat;

/**
 *
 * @author Jose Carlos Palma
 */
public class Cuota {

    public static final DecimalFormat df = new DecimalFormat("+#,##0.00;-#,##0.00");
    public static final int ROUND = 1000000;
    public static final double ROUNDF = (double) ROUND;
    private int periodo;
    private double abonoCapital;
    private double pagoInteres;
    private double abonoCapitalAcumulado;
    private double pagoInteresAcumulado;
    private double saldoCapital;

    public Cuota(int periodo) {
        this.periodo = periodo;
    }

    public Cuota(int p, double ac, double aca, double pi, double pia, double sc) {
        this.periodo = p;
        this.abonoCapital = ac;
        this.abonoCapitalAcumulado = aca;
        this.pagoInteres = pi;
        this.pagoInteresAcumulado = pia;
        this.saldoCapital = sc;
    }

    public void print() {
        System.out.printf("%1$4d %2$16s %3$16s %4$16s %5$16s %6$16s %7$16s\n", periodo, f(abonoCapital + pagoInteres), f(abonoCapital), f(abonoCapitalAcumulado), f(pagoInteres), f(pagoInteresAcumulado), f(saldoCapital));
    }

    /**
     * @return the abonoCapital
     */
    public double getAbonoCapital() {
        return abonoCapital;
    }

    /**
     * @param abonoCapital the abonoCapital to set
     */
    public void setAbonoCapital(double abonoCapital) {
        this.abonoCapital = Math.round(abonoCapital * ROUND) / ROUNDF;
    }

    /**
     * @return the pagoInteres
     */
    public double getPagoInteres() {
        return pagoInteres;
    }

    /**
     * @param pagoInteres the pagoInteres to set
     */
    public void setPagoInteres(double pagoInteres) {
        this.pagoInteres = Math.round(pagoInteres * ROUND) / ROUNDF;
    }

    /**
     * @return the abonoCapitalAcumulado
     */
    public double getAbonoCapitalAcumulado() {
        return abonoCapitalAcumulado;
    }

    /**
     * @param abonoCapitalAcumulado the abonoCapitalAcumulado to set
     */
    public void setAbonoCapitalAcumulado(double abonoCapitalAcumulado) {
        this.abonoCapitalAcumulado = Math.round(abonoCapitalAcumulado * ROUND) / ROUNDF;
    }

    /**
     * @return the pagoInteresAcumulado
     */
    public double getPagoInteresAcumulado() {
        return pagoInteresAcumulado;
    }

    /**
     * @param pagoInteresAcumulado the pagoInteresAcumulado to set
     */
    public void setPagoInteresAcumulado(double pagoInteresAcumulado) {
        this.pagoInteresAcumulado = Math.round(pagoInteresAcumulado * ROUND) / ROUNDF;
    }

    /**
     * @return the saldoCapital
     */
    public double getSaldoCapital() {
        return saldoCapital;
    }

    /**
     * @param saldoCapital the saldoCapital to set
     */
    public void setSaldoCapital(double saldoCapital) {
        this.saldoCapital = Math.round(saldoCapital * ROUND) / ROUNDF;
    }

    private String f(double valor) {
        return df.format(valor);
    }
}
