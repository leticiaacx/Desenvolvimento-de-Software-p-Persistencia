package com.projeto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class InserirContato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Contato contato = inserirContato(scanner);
            inserirContatoNoCSV(contato, "contatos.csv");
            System.out.println("Contato inserido com sucesso no arquivo CSV.");
        } catch (IOException e) {
            System.err.println("Erro ao inserir contato no arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static Contato inserirContato(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Aniversário: ");
        String aniversario = scanner.nextLine();

        Contato contato = new Contato(nome, sobrenome, numero, email, aniversario);
        return contato;
    }

    public static void inserirContatoNoCSV(Contato contato, String arquivoCSV) throws IOException {
        try {
            CSVPrinter csvPrinter;
            boolean arquivoExiste = new java.io.File(arquivoCSV).exists();
            Writer writer = new FileWriter(arquivoCSV, true);
            
            if (!arquivoExiste) {
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Nome", "Sobrenome", "Numero", "Email", "Aniversário"));
            } else {
                csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            }

            csvPrinter.printRecord(contato.getNome(), contato.getSobrenome(), contato.getNumero(), contato.getEmail(), contato.getAniversario());
            csvPrinter.flush();
            csvPrinter.close(arquivoExiste);
        } catch (IOException e) {
            System.err.println("Erro ao inserir contato no CSV: " + e.getMessage());
        }
    }
}
