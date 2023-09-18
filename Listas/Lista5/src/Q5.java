import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Q5 {
    public static void main(String[] args) {
        // Caminho do arquivo XML serializado
        String arquivoXML = "contatos.xml";

        // Crie um objeto ObjectMapper do Jackson para desserialização XML
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            // Desserializa os objetos do arquivo XML
            List<Contato> listaContatos = xmlMapper.readValue(new File(arquivoXML),
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Contato.class));

            // Exibe os contatos desserializados
            System.out.println("Contatos Desserializados a partir de " + arquivoXML + ":");
            for (Contato contato : listaContatos) {
                System.out.println(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
