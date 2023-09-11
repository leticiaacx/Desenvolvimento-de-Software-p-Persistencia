import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class Q3 { 
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso correto: java Q3 <arquivo_criptografado> <arquivo_resultante> <chave>");
            return;
        }

        String arquivoCriptografado = args[0];
        String arquivoResultante = args[1];
        String chave = args[2];

        try {
            // Configurar a chave de descriptografia
            Key key = new SecretKeySpec(chave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            // Abrir o arquivo criptografado para leitura
            FileInputStream fileInputStream = new FileInputStream(arquivoCriptografado);

            // Criar o arquivo resultante da descriptografia
            FileOutputStream fileOutputStream = new FileOutputStream(arquivoResultante);
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);

            // Ler e descriptografar o arquivo criptografado e escrever no arquivo resultante
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cipherInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            // Fechar os fluxos de entrada e saída
            cipherInputStream.close();
            fileOutputStream.close();

            System.out.println("Arquivo descriptografado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao descriptografar o arquivo: " + e.getMessage());
        }
    }
}
