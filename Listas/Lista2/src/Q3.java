import java.io.*;

public class Q3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Passado apenas um argumento na linha de comando!!");
            return;
        }

        String arquivoOrigem = args[0];
        String arquivoDestino = args[1];

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoOrigem), "ISO-8859-1"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoDestino), "UTF-8"));

            String linha;
            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Conversão concluída com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

