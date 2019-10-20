/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.naming.NamingException;

/**
 *
 * @author Drol
 */
public class Introduction extends BaseModel {

    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) throws NamingException {
        this.imagePath = getFolder() + imagePath;
    }

}
