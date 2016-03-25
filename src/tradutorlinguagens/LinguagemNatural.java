/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradutorlinguagens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tradutorlinguagens.Observer.Observado;
import tradutorlinguagens.Observer.Observador;

/**
 *
 * @author TheOwnzs
 */
public class LinguagemNatural implements Observado {    
     private List<Observador> observadores;
     private List<String> lista;
     
    private String Linguagem;

    public LinguagemNatural(String Linguagem) {
        this.Linguagem = Linguagem;
        this.lista = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }
      public LinguagemNatural() { 
        this.lista = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public String getLinguagem() {
        return Linguagem;
    }

    public void setLinguagem(String Linguagem) {
     this.Linguagem = Linguagem;
         notificar();
        
    }    

    @Override
    public void adicionarObserver(Observador o) {
        this.observadores.add(o);
     }

    @Override
    public void notificar() {
        Iterator<Observador> it = this.observadores.iterator();
        while(it.hasNext()) {
            //Passa aqui o parametro para as classes
            it.next().atualizar(Linguagem);
        }
    }        
}
