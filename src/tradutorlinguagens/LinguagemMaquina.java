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
          String Teste = "";
         //Pega a mensagem e transforma em bytes
        byte[] bytes = Ling.getBytes();  
        //Declara uma StringBuilder para receber os campos binarios
          StringBuilder binary = new StringBuilder();  
          
          //Varre o array dos bytes
          for (byte b : bytes) {  
             int val = b;  
             if(val =='\n'){
                 binary.append('\n');
              
             }
             //Converte de byte para binario de acordo com a tabela ASCII
             for (int i = 0; i < 8; i++)  
             {  
                binary.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }            
          }  
          //Define a linguagem como a linguagem convertida em binario
          setLinguagem(binary.toString()+"\n"); 
     }       
}

