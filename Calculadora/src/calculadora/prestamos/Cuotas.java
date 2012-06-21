/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.prestamos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose Carlos Palma
 */
public class Cuotas {
    
    public static final int VALOR_CUOTA = 0;
    public static final int PAGO_CAPITAL = 1;
    public static final int PAGO_INTERES = 2;
    public static final int SALDO = 3;
    private ArrayList<double[]> cuotas = new ArrayList<double[]>();
    
    public Cuotas() {
    }
    
    public void agregarCuotaInfo(double... info) {
        if (info.length != 4) {
            throw new IllegalArgumentException("Se esperaba 4 valores");
        }
        cuotas.add(new double[]{info[VALOR_CUOTA], info[PAGO_CAPITAL], info[PAGO_INTERES], info[SALDO]});
    }
    
    public void setCuotaInfo(int periodo, double... info) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        if (info.length != 4) {
            throw new IllegalArgumentException("Se esperaba 4 valores");
        }
        cuotas.set(periodo - 1, new double[]{info[VALOR_CUOTA], info[PAGO_CAPITAL], info[PAGO_INTERES], info[SALDO]});
    }
    
    public double[] getCuotaInfo(int periodo) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        return cuotas.get(periodo - 1).clone();
    }
    
    private double get(int periodo, int what) {
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        return cuotas.get(periodo - 1)[what];
    }
    
    public double getValorCuota(int periodo) {
        return get(periodo, VALOR_CUOTA);
    }
    
    
    
    public double getPagoCapital(int periodo) {
        return get(periodo, PAGO_CAPITAL);
    }
    
    public double getPagoInteres(int periodo) {
        return get(periodo, PAGO_INTERES);
    }
    
    public double getSaldo(int periodo){
        return get(periodo, SALDO);
    }
    
    private void set(int periodo, int what, double valor){
        if (periodo < 1 || periodo > cuotas.size()) {
            throw new IllegalArgumentException("Período fuera de rango");
        }
        cuotas.get(periodo-1)[what] = valor;
    }
    
    public void setValorCuota(int periodo, double valorCuota){
        set(periodo, VALOR_CUOTA, valorCuota);
    }
    
    public void setPagoCapital(int periodo, double pagoCapital){
        set(periodo, PAGO_CAPITAL, pagoCapital);
    }
    
    public void setPagoInteres(int periodo, double pagoInteres){
        set(periodo, PAGO_INTERES, pagoInteres);
    }
    
    public void setSaldo(int periodo, double saldo){
        set(periodo, SALDO, saldo);
    }
    
    public void print(){
        for(double[] c: cuotas){
            System.out.println( Arrays.toString(c) );
        }
    }
}
