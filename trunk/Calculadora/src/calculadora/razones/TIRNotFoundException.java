/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.razones;

/**
 *
 * @author Jose Carlos Palma
 */
public class TIRNotFoundException extends RuntimeException {

    public TIRNotFoundException(String text) {
        super(text);
    }

    public TIRNotFoundException() {
        super("Tir no encontrada");
    }
}
