import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class Q4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correto: java Q4 <nome_arquivo>");
            return;
        }

        String nomeArquivo = args[0];

        try {
            // Calcular o hash MD5
            long startTime = System.currentTimeMillis();
            String md5Hash = calcularHash(nomeArquivo, "MD5");
            long endTime = System.currentTimeMillis();
            System.out.println("MD5 Hash: " + md5Hash);
            System.out.println("Tempo de execução (MD5): " + (endTime - startTime) + " ms");

            // Calcular o hash SHA-1
            startTime = System.currentTimeMillis();
            String sha1Hash = calcularHash(nomeArquivo, "SHA-1");
            endTime = System.currentTimeMillis();
            System.out.println("SHA-1 Hash: " + sha1Hash);
            System.out.println("Tempo de execução (SHA-1): " + (endTime - startTime) + " ms");

            // Calcular o hash SHA-256
            startTime = System.currentTimeMillis();
            String sha256Hash = calcularHash(nomeArquivo, "SHA-256");
            endTime = System.currentTimeMillis();
            System.out.println("SHA-256 Hash: " + sha256Hash);
            System.out.println("Tempo de execução (SHA-256): " + (endTime - startTime) + " ms");
        } catch (Exception e) {
            System.err.println("Erro ao calcular o hash do arquivo: " + e.getMessage());
        }
    }

    private static String calcularHash(String nomeArquivo, String algoritmo) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algoritmo);
        FileInputStream fis = new FileInputStream(nomeArquivo);
        DigestInputStream dis = new DigestInputStream(fis, digest);
        
        byte[] buffer = new byte[1024];
        while (dis.read(buffer) != -1) {
            // Lê o arquivo para calcular o hash
        }
        
        dis.close();
        
        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();
        
        for (byte hashByte : hashBytes) {
            hexString.append(Integer.toHexString(0xFF & hashByte));
        }
        
        return hexString.toString();
    }
}
