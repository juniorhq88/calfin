/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.razones;

/**
 *
 * @author Jose Carlos Palma
 */
public class TIR {

    private TIR() {
    }

    public static double calcularTIR(Flujos flujos, double inversion) throws TIRNotFoundException {

        double tir = 0.0, tir2, van, vanprima, delta = -1.0;
        int count = 0;

        do {
            van = VPN.calcularValorPresenteNeto(flujos, inversion, tir);
            vanprima = VPN.calcularVPNPrima(flujos, tir);
            tir2 = tir - (van / vanprima);
            delta = Math.abs(tir - tir2);

            tir = tir2;
        } while (++count <= 20 && (int) (delta * 10000000) != 0);

        if (count > 20) {
            throw new TIRNotFoundException("TIR no encontrada [delta=" + delta + "]");
        }


        return tir;
    }
}
