/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.BaseDAO;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Drol
 */
public class Product extends BaseModel {

    private int id;
    private String title;
    private String fullContent;
    private String shortContent;
    private String imagePath;
    private Date publishedDate;
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = getFolder() + imagePath;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price + " $";
    }

    private String getFolder() {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            return (String) envirCxt.lookup("imageFolder");
        } catch (NamingException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
