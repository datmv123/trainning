
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drol
 */
public class _1_FileDemo {

    public static void main(String[] args) throws IOException {
        //=======
        File file = new File("src/data/test.txt");
        System.out.println("File exist: " + file.exists());
        if (file.exists()) {
            System.out.println("File is Directory: " + file.isDirectory());
            System.out.println("File is a file: " + file.isFile());
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Canodical path: " + file.getCanonicalPath());
            System.out.println("Parent: " + file.getParent());
            System.out.println("Path: " + file.getPath());
            System.out.println("Last modify: " + new SimpleDateFormat().format(new Date(file.lastModified())));

        //======
        
        }
    }
}
