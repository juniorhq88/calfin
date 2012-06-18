/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calfin;

import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Palma
 */
public class CuotaNivelada {

    private double prestamo;
    private double tasa;
    private int plazos;
    private TipoPagoAnual pagoAnual;
    private ArrayList<Cuota> cuotas;

    public CuotaNivelada() {
    }

    public CuotaNivelada(double prestamo, double tasa, int plazos, TipoPagoAnual pagoAnual) {
        this.prestamo = prestamo;
        this.tasa = tasa;
        this.plazos = plazos;
        this.pagoAnual = pagoAnual;
        this.cuotas = new ArrayList<Cuota>();
    }

    public void calcular() {

        double saldoCapital = prestamo;
        double abonoCapitalAcu = 0.0;
        double pagoInteresAcu = 0.0;

        //Calcula la cuota nivelada
        double cuotaNivelada = getCuotaNivelada();

        if (Main.debug) {
            System.out.printf("%1$4s %2$16s %3$16s %4$16s %5$16s %6$16s %7$16s\n", "n", "Cuota", "Abono Capital", "Abono Capital Acum", "Interes", "Interes Acum", "Saldo");
        }

        for (int i = 0; i < plazos; i++) {
            Cuota c = new Cuota(i + 1);

            //Calcula el pago de interes.
            c.setPagoInteres(saldoCapital * getTantoPorCiento());
            //Calcula el pago de interes acumulado.
            c.setPagoInteresAcumulado((pagoInteresAcu += c.getPagoInteres()));


            c.setAbonoCapital(cuotaNivelada - c.getPagoInteres());
            //Calcula el abono a capital acumulado.
            c.setAbonoCapitalAcumulado((abonoCapitalAcu += c.getAbonoCapital()));

            c.setSaldoCapital((saldoCapital = prestamo - c.getAbonoCapitalAcumulado()));

            if (Main.debug) {
                c.print();
            }
        }
    }

    /**
     * Calcula la cuota nivelada del préstamo.
     *
     * @return el valor de la cuota nivelada.
     */
    public double getCuotaNivelada() {
        return prestamo * (getTantoPorCiento() / (1 - Math.pow(1 + getTantoPorCiento(), -plazos)));
    }

    /**
     * Calcula el tanto por ciento anual. tasa / j; donde j es el número de pago
     * anual.
     *
     * @return
     */
    public double getTantoPorCiento() {
        return tasa / pagoAnual.valor();
    }

    /**
     * @return the prestamo
     */
    public double getPrestamo() {
        return prestamo;
    }

    /**
     * @param prestamo the prestamo to set
     */
    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * @return the tasa
     */
    public double getTasa() {
        return tasa;
    }

    /**
     * @param tasa la tasa a establecer.
     */
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the plazos
     */
    public int getPlazos() {
        return plazos;
    }

    /**
     * @param plazos the plazos to set
     */
    public void setPlazos(int plazos) {
        this.plazos = plazos;
    }

    /**
     * @return the pagoAnual
     */
    public TipoPagoAnual getPagoAnual() {
        return pagoAnual;
    }

    /**
     * @param pagoAnual the pagoAnual to set
     */
    public void setPagoAnual(TipoPagoAnual pagoAnual) {
        this.pagoAnual = pagoAnual;
    }
}
