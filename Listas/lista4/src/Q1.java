import java.io.*;
import java.util.zip.*;

public class Q1 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Erro! Uso correto: java Q1 <nome_do_arquivo_zip> <pasta>");
            System.exit(1);
        }

        String nomeArquivoZip = args[0];
        String pasta = args[1];

        try {
            FileOutputStream fos = new FileOutputStream(nomeArquivoZip);
            ZipOutputStream zos = new ZipOutputStream(fos);
            compactarPasta(pasta, zos);
            zos.close();
            fos.close();
            System.out.println("Compactação concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao compactar: " + e.getMessage());
        }
    }

    private static void compactarPasta(String pasta, ZipOutputStream zos) throws IOException {
        File diretorio = new File(pasta);

        for (File arquivo : diretorio.listFiles()) {
            if (arquivo.isDirectory()) {
                compactarPasta(arquivo.getPath(), zos);
            } else {
                FileInputStream fis = new FileInputStream(arquivo);
                String entradaNome = arquivo.getPath().replace("\\", "/");
                String zipEntryName = entradaNome.substring(pasta.length() + 1);
                ZipEntry zipEntry = new ZipEntry(zipEntryName);
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, bytesRead);
                }
                fis.close();
            }
        }
    }
}
