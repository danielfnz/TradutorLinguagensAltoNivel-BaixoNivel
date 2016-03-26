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
public class LinguagemFortran implements Observador {
    Main main;
    private String Linguagem;
    private List<String> lista;

    public LinguagemFortran() {
    }

    public LinguagemFortran(Main main) {
        this.main = main;
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
           //Insere no JTexArea
           setLinguagem("Print *, "+Ling+"\n");   
      } 
       
       //Expressao regular para validar atribuicao inteiro x = 5
       if(Ling.matches("\\w+( )[=]( )\\d+|\\w+()[=]()\\d+")){
          //Formula a variavel em fortran;
          String Inteiros = "INTEGER :: "+Ling.substring(0, Ling.lastIndexOf("="));   
          //Insere a variavel formulada no JTexArea (Main)
          main.inserirVariavel(Inteiros); 
          //Atribui valor a variavel
          setLinguagem(Ling+"\n");
       }    
       //Expressão regular para validar atribuicao float, usando virgula.
       if(Ling.matches("\\w+( )[=]( )\\d+,\\d+|\\w+()[=]()\\d+,\\d+")){
           //Formula a variavel em fortran;
           String Floats = "REAL :: "+Ling.substring(0, Ling.lastIndexOf("=")); 
           //Insere a variavel formulada no JTexArea (Main)
           main.inserirVariavel(Floats); 
            //Atribui valor a variavel
           setLinguagem(Ling+"\n");
       }
     
       //Expressão regular para validar atribuicao String.
       if(Ling.matches("\\w+( )[=]( )\"\\D+\"|\\w+()[=]()\"\\D+\"")){
          //Formula a variavel em fortran;
          String Caracteres = "CHARACTER :: "+Ling.substring(0, Ling.lastIndexOf("="));   
          //Insere a variavel formulada no JTexArea (Main)
          main.inserirVariavel(Caracteres); 
          //Atribui valor a variavel
          setLinguagem(Ling+"\n");
       }
        //Expressao regular para validar o Laco de repetição, aceitando 4 espaços entre palavras     
        if(Ling.matches("Repita \\d+x: \"\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\\s\\w+\"")){
            //Formula a variavel em fortran;
            String Inteiros = "INTEGER :: i"; 
            //Insere a variavel formulada no JTexArea (Main)
            main.inserirVariavel(Inteiros); 
            //Pega o valor do x vezes            
            String i = Ling.substring(Ling.indexOf("a ")+2, Ling.indexOf("x:"));
             //Pega o texto
            String texto = Ling.substring(Ling.indexOf("\""), Ling.lastIndexOf("\"")+1);
            //Monta o for com as variaveis            
            String Montar = "do i = 1, "+i+"\n Print *, "+texto+"\nend do\n"; 
            //Seta a linguagem
            setLinguagem(Montar);            
        }
    }
}

