/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.prestamos;

import calculadora.razones.Flujos;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Palma
 */
public class Cuotas {

    /**
     *
     */
    public static final int VALOR_CUOTA = 0;
    /**
     *
     */
    public static final int PAGO_CAPITAL = 1;
    /**
     *
     */
    public static final int PAGO_INTERES = 2;
    /**
     *
     */
    public static final int SALDO = 3;
    private ArrayList<double[]> cuotas = new ArrayList<double[]>();

    /**
     * Crea una instancia de Cuotas.
     */
    public Cuotas() {
    }

    /**
     * Devuelve el tamaño de la lista de cuotas.
     *
     * @return el tamaño de la lista.
     */
    public int size() {
        return cuotas.size();
    }

    /**
     * Indica si la lista de cuotas esta vacía o no.
     *
     * @return true si la lista está vacía, sino retorna false.
     */
    public boolean isEmpty() {
        return cuotas.isEmpty();
    }

    /**
     * Agrega una cuota.
     *
     * @param cuota es el valor de la cuota.
     * @param pagoCapital es el valor del pago a capital.
     * @param pagoInteres es el valor del pago a interés.
     * @param saldo  es el valor del saldo pendiente.
     */
    public void addCuotaInfo(double cuota, double pagoCapital, double pagoInteres, double saldo) {
        cuotas.add(new double[]{cuota, pagoCapital, pagoInteres, saldo});
    }

    /**
     * Modifica la cuota de un periodo específico.
     * @param periodo el número de periodo.
     * @param cuota es el valor de la cuota.
     * @param pagoCapital es el valor del pago a capital.
     * @param pagoInteres es el valor del pago a interés.
     * @param saldo  es el valor del saldo pendiente.
     */
    public void setCuotaInfo(int periodo, double cuota, double pagoCapital, double pagoInteres, double saldo) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        cuotas.set(periodo - 1, new double[]{cuota, pagoCapital, pagoInteres, saldo});
    }

    /**
     * Retorna la cuota de un periodo específico.
     * @param periodo el número de periodo.
     * @return una arreglo con la información de la cuota.
     */
    public double[] getCuotaInfo(int periodo) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        return cuotas.get(periodo - 1);
    }
    
    
    private double get(int periodo, int what) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        return cuotas.get(periodo - 1)[what];
    }

    /**
     * Devuelve el valor de la cuota.
     * @param periodo el número de periodo.
     * @return
     */
    public double getValorCuota(int periodo) {
        return get(periodo, VALOR_CUOTA);
    }

    /**
     * Devuelve el valor del pago a capital.
     * @param periodo el número de periodo.
     * @return
     */
    public double getPagoCapital(int periodo) {
        return get(periodo, PAGO_CAPITAL);
    }

    /**
     * Devuelve el valor del pago a interés.
     * @param periodo el número de periodo.
     * @return
     */
    public double getPagoInteres(int periodo) {
        return get(periodo, PAGO_INTERES);
    }

    /**
     *
     * @param periodo
     * @return
     */
    public double getSaldo(int periodo) {
        return get(periodo, SALDO);
    }

    private void set(int periodo, int what, double valor) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        cuotas.get(periodo - 1)[what] = valor;
    }

    /**
     *
     * @param periodo
     * @param valorCuota
     */
    public void setValorCuota(int periodo, double valorCuota) {
        set(periodo, VALOR_CUOTA, valorCuota);
    }

    /**
     *
     * @param periodo
     * @param pagoCapital
     */
    public void setPagoCapital(int periodo, double pagoCapital) {
        set(periodo, PAGO_CAPITAL, pagoCapital);
    }

    /**
     *
     * @param periodo
     * @param pagoInteres
     */
    public void setPagoInteres(int periodo, double pagoInteres) {
        set(periodo, PAGO_INTERES, pagoInteres);
    }

    /**
     *
     * @param periodo
     * @param saldo
     */
    public void setSaldo(int periodo, double saldo) {
        set(periodo, SALDO, saldo);
    }

    /**
     *
     * @return
     */
    public Flujos getFlujos() {
        Flujos retVal = new Flujos();

        for (double[] c : cuotas) {
            retVal.agregarFlujo(c[VALOR_CUOTA]);
        }

        return retVal;
    }

    private String getSeparador(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i == 7 || (i - 7) % (23) == 0 || i == 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    /**
     *
     */
    public void print() {
        String sep = getSeparador(100);
        DecimalFormat df = new DecimalFormat("#,##0.00 '|'");
        DecimalFormat dfi = new DecimalFormat("#0 '|'");
        double sumCuota = 0.0;
        double sumCapital = 0.0;
        double sumInteres = 0.0;

        System.out.println(sep);
        System.out.print("|");
        System.out.printf("%1$7s %2$22s %3$22s %4$22s %5$22s\n", "No. |", "Cuota |", "Capital |", "Interes |", "Saldo |");
        System.out.println(sep);


        for (int i = 0; i < cuotas.size(); i++) {
            double c[] = cuotas.get(i);
            sumCuota += c[VALOR_CUOTA];
            sumCapital += c[PAGO_CAPITAL];
            sumInteres += c[PAGO_INTERES];
            System.out.print("|");
            System.out.printf("%1$7s %2$22s %3$22s %4$22s %5$22s\n", dfi.format(i + 1),
                    df.format(((int) (c[VALOR_CUOTA] * 100)) / 100.0),
                    df.format(((int) (c[PAGO_CAPITAL] * 100)) / 100.0),
                    df.format(((int) (c[PAGO_INTERES] * 100)) / 100.0),
                    df.format(((int) (c[SALDO] * 100)) / 100.0));
        }
        System.out.println(sep);
        System.out.printf("%1$8s %2$22s %3$22s %4$22s %5$22s\n", "|Total |",
                df.format(sumCuota),
                df.format(sumCapital),
                df.format(sumInteres),
                "");

        System.out.println(getSeparador(77) + "\n");
    }
}
