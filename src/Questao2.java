// 2. Crie uma classe Java para receber via argumento de linha de comando: 
// 1 - um caminho/nome de um arquivo em formato texto e 
// 2 - uma string S. 
// Ao executar, a classe deve exibir somente as linhas do arquivo que tenham a string S 
// como substring.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Questao2{
    public static void main(String[] args) throws IOException{
        String arquivo = args[0];
        String sub = args[1];

        InputStream is = new FileInputStream(arquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int lineNumber = 1; // Variável para acompanhar o número da linha sendo lida

        while(true) {
            String linha = br.readLine(); // Lê uma linha do arquivo
            if (linha != null) {
                if (linha.contains(sub)) {
                    System.out.println(lineNumber + ": " + linha); // Exibe a linha se contiver a substring
                }
                lineNumber++; // Incrementa o número da linha
            } else {
                System.out.println("\n--- Arquivo terminado ---\n");
                break; // Sai do loop quando o final do arquivo for alcançado
            }
        }

        br.close();
    }
}