
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.io.StringReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drol
 */
public class _5_SequenceInputStream {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file1 = new File("src/data/change.txt");
        File file2 = new File("src/data/test.txt");

        BufferedInputStream f1 = new BufferedInputStream(new FileInputStream(file1));
        BufferedInputStream f2 = new BufferedInputStream(new FileInputStream(file2));

        BufferedInputStream ss = new BufferedInputStream(new SequenceInputStream(new BufferedInputStream(new FileInputStream(file1)), new BufferedInputStream(new FileInputStream(file2))));

        int character;
        System.out.println("f1");
        while ((character = f1.read()) != -1) {
            System.out.print((char) character);
        }

        System.out.println("f2");
        while ((character = f2.read()) != -1) {
            System.out.print((char) character);
        }

//        System.out.println("f3");
//        while ((character = ss.read()) != -1) {
//            System.out.print((char) character);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(ss));
        System.out.println("f4");
        String ssssString;
        while ((ssssString = br.readLine()) != null) {
            System.out.print(ssssString);
        }
        
        br.close();
        ss.close();
        f1.close();
        f2.close();
    }
}
