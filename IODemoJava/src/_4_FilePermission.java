
import java.io.File;
import java.io.FilePermission;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drol
 */
public class _4_FilePermission {

    public static void main(String[] args) {
        File file = new File("src/data");
        
        FilePermission ff = new FilePermission("src/data", "read,write");
    }

}
