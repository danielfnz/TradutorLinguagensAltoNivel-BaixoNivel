/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradutorlinguagens.Observer;

/**
 *
 * @author TheOwnzs
 */
public interface Observado {
    public void adicionarObserver(Observador o);
    public void notificar();
    
}
