import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Passado apenas um argumento na linha de comando!!");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        String destinationFilePath = args[1];

        int bufferSize = 8192; // Tamanho do buffer em bytes

        try {
            FileInputStream inputFile = new FileInputStream(sourceFilePath);
            FileOutputStream outputFile = new FileOutputStream(destinationFilePath);

            long startTime = System.currentTimeMillis();

            byte[] buffer = new byte[bufferSize];
            int bytesRead;

            while ((bytesRead = inputFile.read(buffer)) != -1) {
                outputFile.write(buffer, 0, bytesRead);
            }

            inputFile.close();
            outputFile.close();

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.println("Arquivo copiado com sucesso em " + totalTime + " milissegundos.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao copiar o arquivo: " + e.getMessage());
        }
    }
    
    
}
