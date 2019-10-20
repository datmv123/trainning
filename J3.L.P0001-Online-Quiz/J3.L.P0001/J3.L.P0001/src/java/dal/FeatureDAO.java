/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Features;

/**
 *
 * @author Drol
 */
public class FeatureDAO extends BaseDAO<Features> {

    public boolean insert(Features model) throws Exception {
        String sql = "INSERT INTO [Features]\n"
                + "           ([url])\n"
                + "     VALUES\n"
                + "           (?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getURL());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public boolean update(Features model) throws Exception {
        String sql = "UPDATE [Features]\n"
                + "   SET [url] = ?\n"
                + " WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getURL());
            st.setInt(2, model.getId());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM [Features]\n"
                + "      WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public List<Features> getFeaturesByUser(String username) throws Exception {
        List<Features> result = new ArrayList<>();
        String sql = "select a.id, a.url from Features a JOIN Roles_Features b ON a.id = b.featureId\n"
                + "JOIN Roles c ON c.id = b.roleId JOIN Users_Roles d ON d.roleId = c.id\n"
                + "JOIN Users e ON e.username = d.username where d.username like ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, username);
            rs = st.executeQuery();
            while (rs.next()) {
                Features f = new Features();
                f.setId(rs.getInt("id"));
                f.setURL(rs.getString("url"));
                result.add(f);
            }
            return result;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

}
