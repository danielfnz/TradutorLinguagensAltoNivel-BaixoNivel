/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradutorlinguagens;

import tradutorlinguagens.Observer.Observado;
import tradutorlinguagens.Observer.Observador;

/**
 *
 * @author TheOwnzs
 */
public class LinguagemJava implements Observador {
    private String Linguagem;

    public LinguagemJava() {
        Linguagem= "";
    }

    public LinguagemJava(String Linguagem) {
        this.Linguagem = Linguagem;
    }

    public String getLinguagem() {
        return Linguagem;
    }

    public void setLinguagem(String Linguagem) {
        this.Linguagem = Linguagem;
    }    

    @Override
    public void atualizar(Object ob) {
        String Linguagem = ob.toString();        
      if(Linguagem.contains("\"")){
          setLinguagem("System.out.println("+ob.toString()+");\n");    
      }        
    }
    
}
