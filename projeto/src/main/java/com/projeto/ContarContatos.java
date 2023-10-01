package com.projeto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class ContarContatos {
    public static int contarContatos(String arquivoCSV) throws IOException {
        int contador = 0;

        try (FileReader reader = new FileReader(arquivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                System.out.println("Record" + record);
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        String arquivoCSV = "contatos.csv"; // Nome do arquivo CSV

        try {
            int numeroDeContatos = contarContatos(arquivoCSV);
            System.out.println("Número de entidades (contatos) no arquivo CSV: " + numeroDeContatos);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
