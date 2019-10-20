/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author Drol
 */
public class UserDAO extends BaseDAO<Users> {

    public boolean insert(Users model) throws Exception {
        String sql = "INSERT INTO [Users]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getUsername());
            st.setString(2, model.getPassword());
            st.setString(3, model.getEmail());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public Users login(String username, String password) throws Exception {
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "  FROM [Users]\n"
                + "	WHERE username = ? AND password = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            Users model = null;
            while (rs.next()) {
                model = new Users();
                model.setUsername(username);
                model.setPassword(password);
                model.setEmail(rs.getString("email"));
            }
            return model;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public Users get(String username) throws Exception {
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "      ,[email]\n"
                + "  FROM [Users]\n"
                + "	WHERE username = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            Users u = null;
            while (rs.next()) {
                u = new Users();
                u.setUsername(username);
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
            }
            return u;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

}
