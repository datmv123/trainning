/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.BaseModel;

/**
 *
 * @author Drol
 */
public abstract class BaseDAO<T extends BaseModel> {

    private String username;
    private String password;
    private String port;
    private String dbName;
    private String host;

    public BaseDAO() {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            host = (String) envirCxt.lookup("host");
            port = (String) envirCxt.lookup("port");
            username = (String) envirCxt.lookup("username");
            password = (String) envirCxt.lookup("password");
            dbName = (String) envirCxt.lookup("dbName");
        } catch (NamingException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName;
            Connection conn = DriverManager.getConnection(url, username, password);

            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    public void close(Connection con, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
