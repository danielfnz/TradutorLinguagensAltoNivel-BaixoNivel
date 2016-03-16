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
public class LinguagemMaquina implements Observador {
    private String Linguagem;

    public LinguagemMaquina() {
    }

    public LinguagemMaquina(String Linguagem) {
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
         
         int binario;
         //Convertendo ASCII para inteiro, e de inteiro para binario
         StringBuilder sb = new StringBuilder();
         char[] letters = ob.toString().toCharArray(); 
         for (char ch : letters) {              
           sb.append(Integer.toBinaryString(ch));
         }
       
         setLinguagem(sb.toString());
       }
    
}

