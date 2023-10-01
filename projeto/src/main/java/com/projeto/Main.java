package com.projeto;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String arquivoCSV = "contatos.csv";

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir entidade no arquivo CSV");
            System.out.println("2. Mostrar quantidade de entidades no arquivo CSV");
            System.out.println("3. Converter dados para JSON e XML");
            System.out.println("4. Compactar arquivo CSV em ZIP");
            System.out.println("5. Mostrar hash SHA256 do arquivo CSV");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    //chamar InserirContato
                    Contato contato = InserirContato.inserirContato(scanner);
                    InserirContato.inserirContatoNoCSV(contato, arquivoCSV);
                    break;
                case 2:
                    //chamar ContarContatos
                    try{
                    int qntdEntidade = ContarContatos.contarContatos(arquivoCSV);
                    System.out.println("Quantidade de entidades no arquivo CSV: " + qntdEntidade);
                    } catch (IOException e) {
                        System.out.println("Erro ao contar entidades: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    //chamar ConverterCSV
                    try {
                        // Lê os dados do arquivo CSV
                        List<Contato> contatos = ConverterCSV.lerContatosDoCSV(arquivoCSV);

                        // Chama a classe JsonData para converter para JSON
                        ConverterCSV.converterParaJSON(contatos, "contato.json");

                        // Chama a classe XmlData para converter para XML
                        ConverterCSV.converterParaXML(contatos, "contato.xml");

                        System.out.println("Conversão concluída: contatos.json e contatos.xml foram criados.");
                    } catch (IOException e) {
                        System.out.println("Erro ao realizar a conversão: " + e.getMessage());
                        e.printStackTrace(); 
                    }
                    break;
                case 4:
                    //chamar CompactarCSV
                    try {
                        CompactarCSV.compactarArquivo(arquivoCSV, "contatos.zip");
                        System.out.println("Compactação concluída: arquivo CSV compactado para ZIP.");
                    } catch (IOException e) {
                        System.out.println("Erro ao compactar o arquivo CSV: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    //chamar MostrarHASH
                    try {
                        String hash = MostrarHASH.calcularHashSHA256(arquivoCSV);
                        System.out.println("Hash SHA-256 do arquivo CSV: " + hash);
                    } catch (IOException e) {
                        System.out.println("Erro ao calcular o hash: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
