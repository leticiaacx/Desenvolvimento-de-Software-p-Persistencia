import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Questao1{
    public static void main(String[] args) throws IOException{
        String arquivo = args[0];
        //Obtém o nome do arquivo a partir do primeiro argumento da linha de comando
        // Abre o arquivo para leitura
        InputStream is = new FileInputStream(arquivo);//fluxo de bytes 
        InputStreamReader isr = new InputStreamReader(is);//fluxo de caracteres 
        BufferedReader br = new BufferedReader(isr);// buffer para leitura eficiente 

        for (int i = 0; i < 10; i++){ //Loop para ler e imprimir as primeiras 10 linhas do arquivo
            String linha = br.readLine();
            if (linha != null){
                System.out.println(i+1 + ": " + linha);
            } else {
                System.out.println("Não tem mais linhas.");
                break;
            }
        }
        br.close(); //fecha o arquivo após a leitura 
    }
}