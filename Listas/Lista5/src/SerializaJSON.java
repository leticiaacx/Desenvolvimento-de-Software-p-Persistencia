import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializaJSON {
    public static void main(String[] args) {
        // Crie alguns objetos Contato
        Contato contato1 = new Contato("João", "Silva", "Rua A, 123", "(11) 1234-5678");
        Contato contato2 = new Contato("Maria", "Santos", "Rua B, 456", "(22) 9876-5432");

        // Crie uma lista para armazenar os objetos Contato
        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);

        // Crie um objeto ObjectMapper do Jackson para serialização JSON
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            // Serializa a lista de contatos em formato JSON
            String jsonString = jsonMapper.writeValueAsString(listaContatos);

            // Grava o JSON em um arquivo
            File arquivoJSON = new File("contatos.json");
            jsonMapper.writeValue(arquivoJSON, listaContatos);

            System.out.println("Objetos serializados em JSON e gravados em contatos.json:");
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
