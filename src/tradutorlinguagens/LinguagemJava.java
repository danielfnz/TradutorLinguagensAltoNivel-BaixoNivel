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
        Linguagem = "";
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
        String Teste = "";
        String[] lines = Ling.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            //Expressao regular, Se tiver " " 
            if (lines[i].matches("\"\\w+\"|\"\\w+\\s\\w+\"|\"\\w+\\s\\w+\\s\\w+\"|\"\\w+\\s\\w+\\s\\w+\\s\\w+\"|\"\\w+\\s\\w+\\s\\w+\\s\\w+\\s\\w+\"")) {
                Teste += ("System.out.printl(" + lines[i] + ");\n");
            } //Expressao regular para validar atribuicao inteiro x = 5
            else if (lines[i].matches("\\w+( )[=]( )\\d+|\\w+()[=]()\\d+|\\w+()[=]( )\\d+|\\w+( )[=]()\\d+")) {
                Teste += ("int " + lines[i] + ";\n");
            } //Expressão regular para validar atribuicao float, usando virgula.
            else if (lines[i].matches("\\w+( )[=]( )\\d+,\\d+|\\w+()[=]()\\d+,\\d+|\\w+( )[=]( )\\d+\\.\\d+|\\w+()[=]()\\d+\\.\\d+|\\w+()[=]( )\\d+,\\d+|\\w+()[=]()\\d+,\\d+|\\w+()[=]( )\\d+\\.\\d+|\\w+()[=]()\\d+\\.\\d+")) {
                Teste += ("float " + lines[i] + ";\n");
            } //Expressão regular para validar atribuicao String.
            else if (lines[i].matches("\\w+( )[=]( )\"\\D+\"|\\w+()[=]()\"\\D+\"")) {
                Teste += ("String " + lines[i] + ";\n");
            } //Expressao regular para validar o Laco de repetição, aceitando 4 espaços entre palavras     
            else if (lines[i].matches("Repita \\d+x: \"\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\"|Repita \\d+x: \"\\w+\\s\\w+\\s\\w+\\s\\w+\"|Repita \\d+x:\"\\w+\"|Repita \\d+x:\"\\w+\\s\\w+\"|Repita \\d+x:\"\\w+\\s\\w+\\s\\w+\"|Repita \\d+x:\"\\w+\\s\\w+\\s\\w+\\s\\w+\"")) {
                //Pega o valor do x vezes
                String vezes = lines[i].substring(lines[i].indexOf("a ") + 2, lines[i].indexOf("x:"));
                //Pega o texto
                String texto = lines[i].substring(lines[i].indexOf("\""), lines[i].lastIndexOf("\"") + 1);
                //Monta o for com as variaveis            
                String Montar = "for( int i = 0; i < " + vezes + "; i++){\n system.out.println(" + texto + ");\n}\n";
                //Seta a linguagem
                Teste += (Montar);
            }
        }
        setLinguagem(Teste);
    }
}
