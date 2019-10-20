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
import model.Role_Feature;

/**
 *
 * @author Drol
 */
public class Role_FeatureDAO extends BaseDAO<Role_Feature> {

    public boolean insert(Role_Feature model) throws Exception {
        String sql = "INSERT INTO [Roles_Features]\n"
                + "           ([roleId]\n"
                + "           ,[featureId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getRoleId());
            st.setInt(2, model.getFeatureId());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

}
