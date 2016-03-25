/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradutorlinguagens;

import java.util.List;
import tradutorlinguagens.Observer.Observado;
import tradutorlinguagens.Observer.Observador;

/**
 *
 * @author TheOwnzs
 */
public class LinguagemJava implements Observador {
    private String Linguagem;
    private List<String> lista;

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
    public void atualizar(String Ling) {
       if(Ling.contains("\"")){           
           setLinguagem("System.out.printl("+Ling+");\n");
     }    
    }

  
    
}
