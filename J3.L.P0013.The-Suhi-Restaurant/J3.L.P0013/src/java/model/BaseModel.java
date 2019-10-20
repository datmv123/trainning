/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Drol
 */
public abstract class BaseModel {

    protected String getFolder() throws NamingException {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            return (String) envirCxt.lookup("imageFolder");
        } catch (NamingException ex) {
            throw ex;
        }
    }
}
