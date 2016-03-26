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
     public void atualizar(String Ling) {         
        byte[] bytes = Ling.getBytes();  
          StringBuilder binary = new StringBuilder();  
          for (byte b : bytes)  
          {  
             int val = b;  
             for (int i = 0; i < 8; i++)  
             {  
                binary.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }  
            // binary.append(' ');  
          }  
          setLinguagem(binary.toString()+"\n"); 
     }
       
}

