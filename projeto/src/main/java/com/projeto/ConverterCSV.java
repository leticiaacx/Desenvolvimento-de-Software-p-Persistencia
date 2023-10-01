package com.projeto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConverterCSV {
    public static void main(String[] args) {
        String arquivoCSV = "contatos.csv"; // Nome do arquivo CSV
        String arquivoJSON = "contatos.json"; // Nome do arquivo JSON
        String arquivoXML = "contatos.xml"; // Nome do arquivo XML

        try {
            List<Contato> contatos = lerContatosDoCSV(arquivoCSV);

            // Converter para JSON
            converterParaJSON(contatos, arquivoJSON);

            // Converter para XML
            converterParaXML(contatos, arquivoXML);

            System.out.println("Conversão concluída.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    public static List<Contato> lerContatosDoCSV(String arquivoCSV) throws IOException {
        List<Contato> contatos = new ArrayList<>();

        try (FileReader reader = new FileReader(arquivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                Contato contato = new Contato();
                contato.setNome(record.get("Nome"));
                contato.setSobrenome(record.get("Sobrenome"));
                contato.setNumero(record.get("Numero"));
                contato.setEmail(record.get("Email"));
                contato.setAniversario(record.get("Aniversário"));
                contatos.add(contato);
            }
        }

        return contatos;
    }

    public static void converterParaJSON(List<Contato> contatos, String arquivoJSON) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileWriter(arquivoJSON), contatos);
    }

    public static void converterParaXML(List<Contato> contatos, String arquivoXML) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new FileWriter(arquivoXML), contatos);
    }
}
