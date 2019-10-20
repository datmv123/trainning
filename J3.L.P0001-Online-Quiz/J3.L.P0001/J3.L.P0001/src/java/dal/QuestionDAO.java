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
import model.Questions;

/**
 *
 * @author Drol
 */
public class QuestionDAO extends BaseDAO<Questions> {

    public List<Questions> getRandomQuestionsByQuantity(int number) throws Exception {
        List<Questions> questions = new ArrayList<>();
        String sql = "SELECT TOP " + number + " [id]\n"
                + "      ,[question]\n"
                + "      ,[creattionDate]\n"
                + "      ,[authorName]\n"
                + "      ,[optionA]\n"
                + "      ,[optionB]\n"
                + "      ,[optionC]\n"
                + "      ,[optionD]\n"
                + "      ,[optionAIsAnswer]\n"
                + "      ,[optionBIsAnswer]\n"
                + "      ,[optionCIsAnswer]\n"
                + "      ,[optionDIsAnswer]\n"
                + "  FROM [Questions]\n"
                + "ORDER BY NEWID()";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Questions q = new Questions();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setCreationDate(rs.getDate("creattionDate"));
                q.setAuthorName(rs.getString("authorName"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setOptionAIsAnswer(rs.getBoolean("optionAIsAnswer"));
                q.setOptionBIsAnswer(rs.getBoolean("optionBIsAnswer"));
                q.setOptionCIsAnswer(rs.getBoolean("optionCIsAnswer"));
                q.setOptionDIsAnswer(rs.getBoolean("optionDIsAnswer"));
                questions.add(q);
            }
            return questions;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public Questions get(int id) throws Exception {
        String sql = "SELECT [id]\n"
                + "      ,[question]\n"
                + "      ,[creattionDate]\n"
                + "      ,[authorName]\n"
                + "      ,[optionA]\n"
                + "      ,[optionB]\n"
                + "      ,[optionC]\n"
                + "      ,[optionD]\n"
                + "      ,[optionAIsAnswer]\n"
                + "      ,[optionBIsAnswer]\n"
                + "      ,[optionCIsAnswer]\n"
                + "      ,[optionDIsAnswer]\n"
                + "  FROM [Questions]\n"
                + "where id = ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            Questions q = null;
            while (rs.next()) {
                q = new Questions();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setCreationDate(rs.getDate("creattionDate"));
                q.setAuthorName(rs.getString("authorName"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setOptionAIsAnswer(rs.getBoolean("optionAIsAnswer"));
                q.setOptionBIsAnswer(rs.getBoolean("optionBIsAnswer"));
                q.setOptionCIsAnswer(rs.getBoolean("optionCIsAnswer"));
                q.setOptionDIsAnswer(rs.getBoolean("optionDIsAnswer"));
            }
            return q;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM [Questions]\n"
                + "      WHERE id = ? ";
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

    public int countAll() throws Exception {
        String sql = "select count(*) as count from Questions";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public List<Questions> getQuestionsByAuthor(String authorName) throws Exception {
        List<Questions> questions = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[question]\n"
                + "      ,[creattionDate]\n"
                + "      ,[authorName]\n"
                + "      ,[optionA]\n"
                + "      ,[optionB]\n"
                + "      ,[optionC]\n"
                + "      ,[optionD]\n"
                + "      ,[optionAIsAnswer]\n"
                + "      ,[optionBIsAnswer]\n"
                + "      ,[optionCIsAnswer]\n"
                + "      ,[optionDIsAnswer]\n"
                + "  FROM [Questions]\n"
                + "WHERE authorName like ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, authorName);
            rs = st.executeQuery();
            while (rs.next()) {
                Questions q = new Questions();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setCreationDate(rs.getDate("creattionDate"));
                q.setAuthorName(rs.getString("authorName"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setOptionAIsAnswer(rs.getBoolean("optionAIsAnswer"));
                q.setOptionBIsAnswer(rs.getBoolean("optionBIsAnswer"));
                q.setOptionCIsAnswer(rs.getBoolean("optionCIsAnswer"));
                q.setOptionDIsAnswer(rs.getBoolean("optionDIsAnswer"));
                questions.add(q);
            }
            return questions;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public int countQuestionsByAuthor(String authorName) throws Exception {
        String sql = "select count(*) as count from Questions where authorName like ?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, authorName);
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

    public List<Questions> getQuestionsByAuthorPagging(String authorName, int page, int pageSize) throws Exception {
        List<Questions> questions = new ArrayList<>();
        String sql = "select * from (SELECT *,ROW_NUMBER() OVER (ORDER BY id) as rn\n"
                + "  FROM [Questions] where authorName like ?\n"
                + "  ) as x\n"
                + "where x.rn between (?-1)*? + 1 and ?*?";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, authorName);
            st.setInt(2, page);
            st.setInt(3, pageSize);
            st.setInt(4, page);
            st.setInt(5, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                Questions q = new Questions();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setCreationDate(rs.getDate("creattionDate"));
                q.setAuthorName(rs.getString("authorName"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setOptionAIsAnswer(rs.getBoolean("optionAIsAnswer"));
                q.setOptionBIsAnswer(rs.getBoolean("optionBIsAnswer"));
                q.setOptionCIsAnswer(rs.getBoolean("optionCIsAnswer"));
                q.setOptionDIsAnswer(rs.getBoolean("optionDIsAnswer"));
                questions.add(q);
            }
            return questions;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }

    public boolean insert(Questions model) throws Exception {
        String sql = "INSERT INTO [Questions]\n"
                + "           ([question]\n"
                + "           ,[creattionDate]\n"
                + "           ,[authorName]\n"
                + "           ,[optionA]\n"
                + "           ,[optionB]\n"
                + "           ,[optionC]\n"
                + "           ,[optionD]\n"
                + "           ,[optionAIsAnswer]\n"
                + "           ,[optionBIsAnswer]\n"
                + "           ,[optionCIsAnswer]\n"
                + "           ,[optionDIsAnswer])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        Connection conn = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getQuestion());
            st.setDate(2, model.getCreationDate());
            st.setString(3, model.getAuthorName());
            st.setString(4, model.getOptionA());
            st.setString(5, model.getOptionB());
            st.setString(6, model.getOptionC());
            st.setString(7, model.getOptionD());
            st.setBoolean(8, model.isOptionAIsAnswer());
            st.setBoolean(9, model.isOptionBIsAnswer());
            st.setBoolean(10, model.isOptionCIsAnswer());
            st.setBoolean(11, model.isOptionDIsAnswer());
            return st.executeUpdate() == 1;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            close(conn, st, rs);
        }
    }
}
