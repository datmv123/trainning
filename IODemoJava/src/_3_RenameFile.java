
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drol
 */
public class _3_RenameFile {

    public static void main(String[] args) {
        File file = new File("src/data/test.txt");
        file.renameTo(new File("src/data/change.txt"));

        file.delete(); //delete file or directory
    }

}
