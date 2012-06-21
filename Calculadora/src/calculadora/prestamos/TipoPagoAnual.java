/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.prestamos;

/**
 *
 * @author Jose Carlos Palma
 */
public enum TipoPagoAnual {
    
    SEMANAL(52),
    QUINCENAL(24),
    MENSUAL(12),
    BIMESTRAL(6),
    TRIMESTRAL(4),
    CUATRIMESTRAL(3),
    SEMESTRAL(2),
    ANUAL(1);
    
    private int valor;
    
    TipoPagoAnual(int val){
        this.valor = val;
    }
    
    public int valor(){
        return this.valor;
    }
}
