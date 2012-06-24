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

    /**
     * Calcula las cuotas de un préstamo utilizando el método de saldo insoluto.
     * @param monto es el valor del préstamo.
     * @param tasa es la tasa nominal.
     * @param plazos es el número de periodos en que se va a pagar el préstamo.
     * @param tipo es el tipo de tasa o el tanto por ciento, por ejemplo:
     * Semana, Quincenal, Mensual, etc)
     * @param periodoInicial es el periodo en donde se va a realizar el primer pago.
     * @return una lista de Cuotas.
     */
    public static Cuotas calcularSaldoInsoluto(double monto, double tasa, int plazos, TipoTasa tipo, int periodoInicial) {
        Cuotas retVal = new Cuotas();

        double saldo = monto;
        final double pagoCapital = monto / plazos;
        double pi;

        for (int i = 1; i <= (periodoInicial - 1); i++) {
            retVal.addCuotaInfo(0, 0, 0, saldo);
        }

        for (int i = 1; i <= plazos; i++) {
            pi = saldo * tpc(tasa, tipo);
            saldo -= pagoCapital;
            retVal.addCuotaInfo(pagoCapital + pi, pagoCapital, pi, saldo);
        }

        return retVal;
    }

    /**
     * Calcula las cuotas de un préstamo utilizando el método de saldo insoluto.
     * @param monto es el valor del préstamo.
     * @param tasa es la tasa nominal.
     * @param plazos es el número de periodos en que se va a pagar el préstamo.
     * @param tipo es el tipo de tasa o el tanto por ciento, por ejemplo:
     * Semana, Quincenal, Mensual, etc)
     * @return
     */
    public static Cuotas calcularSaldoInsoluto(double monto, double tasa, int plazos, TipoTasa tipo) {
        return calcularSaldoInsoluto(monto, tasa, plazos, tipo, 1);
    }

    /**
     * Calcula las cuotas de un préstamo utilizando el método de cuota nivelada.
     * @param monto es el valor del préstamo.
     * @param tasa es la tasa nominal.
     * @param plazos es el número de periodos en que se va a pagar el préstamo.
     * @param tipo es el tipo de tasa o el tanto por ciento, por ejemplo:
     * Semana, Quincenal, Mensual, etc)
     * @param periodoInicial es el periodo en donde se va a realizar el primer pago.
     * @return una lista de Cuotas.
     */
    public static Cuotas calcularCuotaNivelada(double monto, double tasa, int plazos, TipoTasa tipo, int periodoInicial) {
        Cuotas retVal = new Cuotas();

        double cuota = getCuotaNivelada(monto, tasa, plazos, tipo);
        double saldo = monto;

        for (int i = 1; i <= (periodoInicial - 1); i++) {
            retVal.addCuotaInfo(0, 0, 0, saldo);
        }

        for (int i = 1; i <= plazos; i++) {
            double pi = saldo * tpc(tasa, tipo);
            saldo -= (cuota - pi);
            retVal.addCuotaInfo(cuota, cuota - pi, pi, saldo);
        }

        return retVal;
    }

    /**
     * Calcula las cuotas de un préstamo utilizando el método de cuota nivelada.
     * @param monto es el valor del préstamo.
     * @param tasa es la tasa nominal.
     * @param plazos es el número de periodos en que se va a pagar el préstamo.
     * @param tipo es el tipo de tasa o el tanto por ciento, por ejemplo:
     * Semana, Quincenal, Mensual, etc)
     * @return una lista de Cuotas.
     */
    public static Cuotas calcularCuotaNivelada(double monto, double tasa, int plazos, TipoTasa tipo) {
        return calcularCuotaNivelada(monto, tasa, plazos, tipo, 1);
    }

    /**
     * Obtiene el valor de la cuota del préstamo utilizando el método de cuota
     * nivelada.
     *
     * @param monto es el valor del préstamo.
     * @param tasa es la tasa nominal.
     * @param plazos es el número de periodos en que se va a pagar el préstamo.
     * @param tipo es el tipo de tasa o el tanto por ciento, por ejemplo:
     * Semana, Quincenal, Mensual, etc)
     * @return
     */
    public static double getCuotaNivelada(double monto, double tasa, int plazos, TipoTasa tipo) {
        return monto * tpc(tasa, tipo) / (1 - Math.pow(1 + tpc(tasa, tipo), -plazos));
    }

    /**
     * Devuelve el valor del tipo de tasa, mediante la formula: Tasa / Tipo.
     * <BR>Nota: este valor se utiliza para calcular el valor del interés sobre
     * el capital.
     *
     * @param tasa es la tasa nominal.
     * @param tipo es el tipo de tasa o el tanto por ciento de interés.
     * @return el valor del tanto por ciento.
     */
    public static double tpc(double tasa, TipoTasa tipo) {
        return tasa / tipo.valor();
    }
}
