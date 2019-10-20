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
import model.Information;

/**
 *
 * @author Drol
 */
public class InformationDAO extends BaseDAO<Information> {

    public Information getInformation() throws Exception {
        String sql = "SELECT [content]\n"
                + "      ,[address]\n"
                + "      ,[phone]\n"
                + "      ,[author]\n"
                + "  FROM [Information]";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Information ii = new Information();
                ii.setAddress(rs.getString("address"));
                ii.setAuthor(rs.getString("author"));
                ii.setContent(rs.getString("content"));
                ii.setPhone(rs.getString("phone"));
                return ii;
            }
            return null;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }
}
