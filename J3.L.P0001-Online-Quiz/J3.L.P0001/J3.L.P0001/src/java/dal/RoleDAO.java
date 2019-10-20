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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Roles;

/**
 *
 * @author Drol
 */
public class RoleDAO extends BaseDAO<Roles> {

    public List<Roles> getAll() throws Exception {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM [Roles]";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Roles r = new Roles();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                roles.add(r);
            }
            return roles;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public boolean insert(Roles model) throws Exception {
        String sql = "INSERT INTO [Roles]\n"
                + "           ([name])\n"
                + "     VALUES\n"
                + "           (?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getName());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public List<Roles> getRolesByUser(String username) throws Exception {
        List<Roles> roles = new ArrayList<>();
        String sql = "select a.id,a.name from Roles a JOIN Users_Roles b ON a.id = b.roleId\n"
                + "JOIN Users c ON c.username = b.username where c.username like ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            while (rs.next()) {
                Roles r = new Roles();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                roles.add(r);
            }
            return roles;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public Roles get(int role) throws Exception {
        List<Roles> roles = new ArrayList<>();
        String sql = "SELECT * FROM [Roles] where id = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, role);
            rs = st.executeQuery();
            while (rs.next()) {
                Roles r = new Roles();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                return r;
            }
            return null;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

}
