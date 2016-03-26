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
       //Expressao regular, Se tiver " " 
       if(Ling.matches("\"\\w+\"")){           
           setLinguagem("System.out.printl("+Ling+");\n");
      } 
       
       //Expressao regular para validar atribuicao inteiro x = 5
       if(Ling.matches("\\w+( )[=]( )\\d+|\\w+()[=]()\\d+")){
           setLinguagem("int "+Ling+";\n");
       }    
       //Expressão regular para validar atribuicao float, usando virgula.
       if(Ling.matches("\\w+( )[=]( )\\d+,\\d+|\\w+()[=]()\\d+,\\d+")){
           setLinguagem("float "+Ling+";\n");
       }
     
       //Expressão regular para validar atribuicao String.
       if(Ling.matches("\\w+( )[=]( )\"\\D+\"|\\w+()[=]()\"\\D+\"")){
           setLinguagem("String "+Ling+";\n");
       }
        //Expressao regular para validar o Laco de repetição, aceitando 4 espaços entre palavras     
        if(Ling.matches("Repita \\d+x: \"\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\\s\\w+\"")){
            //Pega o valor do x vezes
            String i = Ling.substring(Ling.indexOf("a ")+2, Ling.indexOf("x:"));
             //Pega o texto
            String texto = Ling.substring(Ling.indexOf("\""), Ling.lastIndexOf("\"")+1);
            //Monta o for com as variaveis            
            String Montar = "for( int i = 0; i < "+i+"; i++){\n system.out.println("+texto+");\n}\n"; 
            //Seta a linguagem
            setLinguagem(Montar);            
        }
    }    
}
