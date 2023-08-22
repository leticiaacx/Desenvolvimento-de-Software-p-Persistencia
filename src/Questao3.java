// 3. Crie uma classe Java para receber via argumento de linha de comando os caminhos/nomes
// de 2 arquivos em formato texto e, em seguida, listar todas as linhas de ambos os arquivos.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Questao3 {
    public static void main(String[] args) throws IOException {
        String arquivo1 = args[0];// Obtém o nome do primeiro arquivo a partir dos argumentos de linha de comando
        String arquivo2 = args[1];// Obtém o nome do segundo arquivo a partir dos argumentos de linha de comando

        // Abre o primeiro arquivo
        InputStream is1 = new FileInputStream(arquivo1);// Cria um fluxo de entrada para o primeiro arquivo
        InputStreamReader isr1 = new InputStreamReader(is1);// Cria um leitor de caracteres a partir do fluxo de entrada
        BufferedReader br1 = new BufferedReader(isr1);// Cria um leitor de linhas a partir do leitor de caracteres

        System.out.println("--- Arquivo um ---\n");// Imprime uma mensagem indicando o início do primeiro arquivo
        for (int i = 0; ; i++) {
            String linha = br1.readLine();// Lê uma linha do primeiro arquivo

            if (linha != null) {
                System.out.println(i + 1 + ": " + linha);// Exibe a linha atual do primeiro arquivo
            } else {
                System.out.println("\n--- Arquivo encerrado ---\n");// Imprime uma mensagem indicando o final do primeiro arquivo
                break; // Sai do loop quando o final do arquivo é alcançado
            }
        }

        br1.close(); // Fecha o leitor de linhas do primeiro arquivo

        // Abre o segundo arquivo (mesmo procedimento que o primeiro arquivo)
        InputStream is2 = new FileInputStream(arquivo2);
        InputStreamReader isr2 = new InputStreamReader(is2);
        BufferedReader br2 = new BufferedReader(isr2);

        System.out.println("--- Arquivo dois ---\n");// Imprime uma mensagem indicando o início do segundo arquivo
        for (int i = 0; ; i++) {
            String linha = br2.readLine();// Lê uma linha do segundo arquivo

            if (linha != null) {
                System.out.println(i + 1 + ": " + linha);  // Exibe a linha atual do segundo arquivo
            } else {
                System.out.println("\n--- Arquivo encerrado ---");// Imprime uma mensagem indicando o final do segundo arquivo
                break;// Sai do loop quando o final do arquivo é alcançado
            }
        }

        br2.close();// Fecha o leitor de linhas do segundo arquivo
    }
}
