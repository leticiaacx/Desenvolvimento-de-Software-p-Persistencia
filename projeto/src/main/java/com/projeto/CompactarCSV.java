package com.projeto;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactarCSV {
    public static void main(String[] args) {
        String arquivoCSV = "contatos.csv"; 
        String arquivoZIP = "contatos.zip"; 

        try {
            compactarArquivo(arquivoCSV, arquivoZIP);
            System.out.println("Compactação concluída.");
        } catch (IOException e) {
            System.err.println("Erro ao compactar o arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void compactarArquivo(String arquivoCSV, String arquivoZIP) throws IOException {
        try (
            FileInputStream fis = new FileInputStream(arquivoCSV);
            FileOutputStream fos = new FileOutputStream(arquivoZIP);
            ZipOutputStream zipOut = new ZipOutputStream(fos)
        ) {
            ZipEntry zipEntry = new ZipEntry(arquivoCSV);
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.closeEntry();
        }
    }
}
