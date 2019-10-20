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
import model.Contact;

/**
 *
 * @author Drol
 */
public class ContactDAO extends BaseDAO {

    public Contact getContact() throws Exception {
        String sql = "SELECT [address]\n"
                + "      ,[tel]\n"
                + "      ,[email]\n"
                + "      ,[workingHour]\n"
                + "      ,[mapPath]\n"
                + "  FROM [Contact] ";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Contact cc = new Contact();
                cc.setAddress(rs.getString("address"));
                cc.setEmail(rs.getString("email"));
                cc.setMapPath(rs.getString("mapPath"));
                cc.setTel(rs.getString("tel"));
                cc.setWorkingHour(rs.getString("workingHour"));
                return cc;
            }
            return null;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }
}
