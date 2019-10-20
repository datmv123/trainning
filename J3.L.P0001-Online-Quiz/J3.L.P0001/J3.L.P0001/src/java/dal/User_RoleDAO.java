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
import model.User_Role;

/**
 *
 * @author Drol
 */
public class User_RoleDAO extends BaseDAO<User_Role> {

    public boolean insert(User_Role model) throws Exception {
        String sql = "INSERT INTO [Users_Roles]\n"
                + "           ([username]\n"
                + "           ,[roleId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getUsername());
            st.setInt(2, model.getRoleId());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }


}
