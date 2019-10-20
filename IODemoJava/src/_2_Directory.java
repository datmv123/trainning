
import java.io.File;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drol
 */
public class _2_Directory {

    public static void main(String[] args) {
        File file = new File("src/data/test");
        System.out.println("File is Directory: " + file.isDirectory());
        if (file.isDirectory()) {
            Arrays.asList(file.listFiles()).forEach((t) -> {
                System.out.println("child: " + t.getName());
            });
        }
        File makeDirectory = new File("src/data/directory/son");
        if (makeDirectory.exists()) {
            System.out.println("directory is exist.");
        } else {
            makeDirectory.mkdir();// make directory with path
//            makeDirectoroy.mkdirs(); //make directoty with path. if its parent is not exist then create parent too.
            if (makeDirectory.exists()) {
                System.out.println("create directory.");
            } else {
                System.out.println("create fail.");
            }
        }
    }
}
