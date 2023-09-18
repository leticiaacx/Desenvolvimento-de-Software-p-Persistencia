import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializaJava {
    public static void main(String[] args) {
        // Crie alguns objetos Contato
        Contato contato1 = new Contato("João", "Silva", "Rua A, 123", "(11) 1234-5678");
        Contato contato2 = new Contato("Maria", "Santos", "Rua B, 456", "(22) 9876-5432");

        // Crie uma lista para armazenar os objetos Contato
        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);

        // Caminho do arquivo onde os objetos serão serializados
        String arquivoSerializacao = "contatos.ser";

        try {
            // Crie um fluxo de saída para gravar os objetos no arquivo
            FileOutputStream fileOutputStream = new FileOutputStream(arquivoSerializacao);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Serializa a lista de contatos e escreve-a no arquivo
            objectOutputStream.writeObject(listaContatos);

            // Feche os fluxos de saída
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Objetos serializados e gravados em " + arquivoSerializacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
