//import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Lendo um arquivo inteiro 
public class Ex7{
    public static void main(String[] args) throws IOException{
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine(); 

        while(s != null){
            System.out.println(s);
            s = br.readLine();
        }
    }
}
