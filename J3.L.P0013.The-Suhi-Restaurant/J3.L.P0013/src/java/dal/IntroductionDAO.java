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
import model.Introduction;

/**
 *
 * @author Drol
 */
public class IntroductionDAO extends BaseDAO {

    public Introduction getIntroduction() throws Exception {
        String sql = "select * from introduction";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Introduction ii = new Introduction();
                ii.setImagePath(rs.getString("imagePath"));
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
