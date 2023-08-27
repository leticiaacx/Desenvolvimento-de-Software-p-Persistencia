import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Q4 {
    public static void main(String[] args) {
        StringBuilder content = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine();

        while(!(line.contains("FIM"))){
            content.append(line).append("\n");
            line = sc.nextLine();
        }

        System.out.print("Informe o nome do arquivo de saída: ");
        String fileName = sc.nextLine();

        try(FileWriter fw = new FileWriter(fileName, StandardCharsets.ISO_8859_1)) {
            fw.write(content.toString());// escrever o conteudo armazenado no stringbuilder
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

