import java.io.*;
import java.util.List;

public class Deserializa{
    public static void main(String[] args) {
        // Caminho do arquivo onde os objetos foram serializados
        String arquivoSerializacao = "contatos.ser";

        try {
            // Crie um fluxo de entrada para ler os objetos do arquivo
            FileInputStream fileInputStream = new FileInputStream(arquivoSerializacao);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Desserializa a lista de contatos do arquivo
            List<Contato> listaContatos = (List<Contato>) objectInputStream.readObject();

            // Feche os fluxos de entrada
            objectInputStream.close();
            fileInputStream.close();

            // Exibe os contatos desserializados
            System.out.println("Contatos Desserializados:");
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
