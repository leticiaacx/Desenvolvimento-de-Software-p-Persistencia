import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Q4 {
    public static void main(String[] args) {
        // Crie alguns objetos Contato
        Contato contato1 = new Contato("João", "Silva", "Rua A, 123", "(11) 1234-5678");
        Contato contato2 = new Contato("Maria", "Santos", "Rua B, 456", "(22) 9876-5432");

        // Crie uma lista para armazenar os objetos Contato
        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(contato1);
        listaContatos.add(contato2);

        // Crie um objeto ObjectMapper do Jackson para serialização XML
        ObjectMapper xmlMapper = new XmlMapper();

        try {
            // Serializa a lista de contatos em formato XML
            String xmlString = xmlMapper.writeValueAsString(listaContatos);

            // Grava o XML em um arquivo
            File arquivoXML = new File("contatos.xml");
            xmlMapper.writeValue(arquivoXML, listaContatos);

            System.out.println("Objetos serializados em XML e gravados em contatos.xml:");
            System.out.println(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

