/*1. Escreva uma aplicação Java para ler um arquivo texto ou binário qualquer e gravá-lo em outro arquivo (arquivo destino).

- Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
- A leitura e gravação devem ser realizadas byte a byte.
- Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida. Dica: pode-se usar o método System.currentTimeMillis().
- Em caso de qualquer erro, enviar uma mensagem pela saída padrão de erro (System.err).*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        if (args.length < 2) { // verificar se houve pelo menos dois argumentos na linha de comando 
            System.err.println("Passado apenas um argumento na linha de comando!!");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        String destinationFilePath = args[1];

        try {
            FileInputStream inputFile = new FileInputStream(sourceFilePath);
            FileOutputStream outputFile = new FileOutputStream(destinationFilePath);

            long startTime = System.currentTimeMillis(); // O tempo de início da cópia é registrado

            int bytesRead;
            // lê bytes do arquivo de origem para o buffer e, em seguida, escreve esses
            // bytes no arquivo de destino
            while ((bytesRead = inputFile.read()) != -1) {
                outputFile.write(bytesRead);
            }

            inputFile.close();
            outputFile.close();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime; // aqui é calculado o tempo que levou para fazer a cópia 

            System.out.println("Arquivo copiado com sucesso em " + totalTime + " milissegundos.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
