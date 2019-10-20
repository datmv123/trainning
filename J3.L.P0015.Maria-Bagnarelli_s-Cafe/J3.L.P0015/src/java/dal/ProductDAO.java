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
import model.Product;

/**
 *
 * @author Drol
 */
public class ProductDAO extends BaseDAO<Product> {

    public List<Product> getProductPaging(int pageIndex, int pageSize) throws Exception {
        List<Product> result = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[title]\n"
                + "      ,[fullContent]\n"
                + "      ,[shortContent]\n"
                + "      ,[imagePath]\n"
                + "      ,[publishedDate]\n"
                + "      ,[price]\n"
                + "  FROM (select *, ROW_NUMBER() over (order by id) as rn from Products) as x\n"
                + "where x.rn between (?-1)*? + 1 and ?*?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, pageIndex);
            st.setInt(2, pageSize);
            st.setInt(3, pageIndex);
            st.setInt(4, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                Product pp = new Product();
                pp.setId(rs.getInt("id"));
                pp.setFullContent(rs.getString("fullContent"));
                pp.setShortContent(rs.getString("shortContent"));
                pp.setImagePath(rs.getString("imagePath"));
                pp.setPrice(rs.getFloat("price"));
                pp.setPublishedDate(rs.getDate("publishedDate"));
                pp.setTitle(rs.getString("title"));
                result.add(pp);
            }
            return result;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public Product get(int id) throws Exception {
        String sql = "select * from products where id = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Product pp = new Product();
                pp.setId(rs.getInt("id"));
                pp.setFullContent(rs.getString("fullContent"));
                pp.setShortContent(rs.getString("shortContent"));
                pp.setImagePath(rs.getString("imagePath"));
                pp.setPrice(rs.getFloat("price"));
                pp.setPublishedDate(rs.getDate("publishedDate"));
                pp.setTitle(rs.getString("title"));
                return pp;
            }
            return null;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public int count() throws Exception {
        String sql = "select count(*) as count from Products ";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("count");
            }
            return 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public List<Product> getProductSortByDate(int quantity) throws Exception {
        List<Product> result = new ArrayList<>();
        String sql = "select top " + quantity + " * from Products \n"
                + "order by publishedDate desc";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Product pp = new Product();
                pp.setId(rs.getInt("id"));
                pp.setFullContent(rs.getString("fullContent"));
                pp.setShortContent(rs.getString("shortContent"));
                pp.setImagePath(rs.getString("imagePath"));
                pp.setPrice(rs.getFloat("price"));
                pp.setPublishedDate(rs.getDate("publishedDate"));
                pp.setTitle(rs.getString("title"));
                result.add(pp);
            }
            return result;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }
}
