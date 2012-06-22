/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.prestamos;

/**
 *
 * @author Jose Carlos Palma
 */
public class Prestamo {

    private Prestamo() {
    }
    
    public static Cuotas calcularCuotaNivelada(double monto, double tasa, int plazos, TipoPagoAnual tipo, int periodoInicial) {
        Cuotas retVal = new Cuotas();
        
        double cuota = cuotaNivelada(monto, tasa, plazos, tipo);
        double saldo = monto;
        
        for(int i = 1; i <= (periodoInicial-1); i++){
            retVal.agregarCuotaInfo(0,0,0,saldo);
        }
        
        for(int i = 1; i <= plazos; i++){
             double pi = saldo * tpc(tasa, tipo);
             saldo -= (cuota - pi);
             retVal.agregarCuotaInfo(cuota, cuota - pi, pi, saldo);
        }

        return retVal;
    }

    public static Cuotas calcularCuotaNivelada(double monto, double tasa, int plazos, TipoPagoAnual tipo) {
        return calcularCuotaNivelada(monto, tasa, plazos, tipo, 1);
    }

    public static double cuotaNivelada(double monto, double tasa, int plazos, TipoPagoAnual tipo) {
        return monto * tpc(tasa, tipo) / (1 - Math.pow(1 + tpc(tasa, tipo), -plazos));
    }

    public static double tpc(double tasa, TipoPagoAnual tipo) {
        return tasa / tipo.valor();
    }
}
