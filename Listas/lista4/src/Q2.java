import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class Q2 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso correto: java Q2 <arquivo_origem> <arquivo_destino> <chave>");
            return;
        }

        String arquivoOrigem = args[0];
        String arquivoDestino = args[1];
        String chave = args[2];

        try {
            // Configurar a chave de criptografia
            Key key = new SecretKeySpec(chave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // Abrir o arquivo de origem para leitura
            FileInputStream fileInputStream = new FileInputStream(arquivoOrigem);

            // Criar o arquivo de destino criptografado
            FileOutputStream fileOutputStream = new FileOutputStream(arquivoDestino);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);

            // Ler e criptografar o arquivo de origem e escrever no arquivo de destino
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                cipherOutputStream.write(buffer, 0, bytesRead);
            }

            // Fechar os fluxos de entrada e saída
            fileInputStream.close();
            cipherOutputStream.close();

            System.out.println("Arquivo criptografado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criptografar o arquivo: " + e.getMessage());
        }
    }
}
