//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Lendo um arquivo inteiro 
public class LendoArq {
    public static void main(String[] args) throws IOException{
        InputStream is = new FileInputStream(args[0]);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine(); 

        while(s != null){
            System.out.println(s);
            s = br.readLine();
        }

        br.close();
    }
}
