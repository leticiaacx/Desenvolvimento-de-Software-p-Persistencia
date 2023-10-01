package com.projeto;

import java.io.*;
import java.security.MessageDigest;

public class MostrarHASH {
    public static void main(String[] args) {
        String arquivoCSV = "contatos.csv";

        try {
            String hashSHA256 = calcularHashSHA256(arquivoCSV);
            System.out.println("Hash SHA-256 do arquivo CSV: " + hashSHA256);
        } catch (IOException e) {
            System.err.println("Erro ao calcular o hash SHA-256: " + e.getMessage());
        }
    }

    public static String calcularHashSHA256(String arquivoCSV) throws IOException {
        try (FileInputStream fis = new FileInputStream(arquivoCSV)) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

            byte[] hashBytes = digest.digest();
            return bytesToHex(hashBytes);
        } catch (Exception e) {
            throw new IOException("Erro ao calcular o hash SHA-256", e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexStringBuilder.append(String.format("%02x", b & 0xff));
        }
        return hexStringBuilder.toString();
    }
}
