import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DesserializaJSON {
    public static void main(String[] args) {
        // Caminho do arquivo JSON serializado
        String arquivoJSON = "contatos.json";

        // Crie um objeto ObjectMapper do Jackson para desserialização JSON
        ObjectMapper jsonMapper = new ObjectMapper();

        try {
            // Desserializa os objetos do arquivo JSON
            List<Contato> listaContatos = jsonMapper.readValue(new File(arquivoJSON),
                    jsonMapper.getTypeFactory().constructCollectionType(List.class, Contato.class));

            // Exibe os contatos desserializados
            System.out.println("Contatos Desserializados a partir de " + arquivoJSON + ":");
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
