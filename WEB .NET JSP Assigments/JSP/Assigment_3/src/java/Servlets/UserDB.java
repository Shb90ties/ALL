package Servlets;

import java.sql.*;
import java.util.*;

public class UserDB 
{
    private final Connection connection;
    
    public UserDB() 
    {
        connection = DBUtil.getConnection();
    }
    
    public boolean addSQL_Q(SQL_Q sql_q) 
    {
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("insert into QUESTIONS values (?, ?, ?, ?, ?)");
            pStatement.setString(1, sql_q.getCode());
            pStatement.setInt(2, sql_q.getType());
            pStatement.setInt(3, sql_q.getDifficulty());
            pStatement.setString(4, sql_q.getQuestion());
            pStatement.setString(5, sql_q.getCategory());
            pStatement.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {
            return false;
        }
    }
    
    public boolean deleteSQL_Q(String code) 
    {
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("delete from QUESTIONS where CODE=?");
            pStatement.setString(1, code);
            pStatement.executeUpdate();
        }
        catch (SQLException e) 
        {
            return false;
        }
        return true;
    }
    
    public void deleteSQL_A(String code)
    {
        for(int i=0; i<5; i++)
        {
            delete_SQL_A(code);
        }
    }
    
    private boolean delete_SQL_A(String code) 
    {
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("delete from ANSWERS where CODE=?");
            pStatement.setString(1, code);
            pStatement.executeUpdate();
        }
        catch (SQLException e) 
        {
            return false;
        }
        return true;
    }
    
    public boolean addSQL_A(SQL_A sql_a)
    {
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("insert into ANSWERS values (?, ?, ?, ?)");
            pStatement.setString(1, sql_a.getCode());
            pStatement.setInt(2, sql_a.getType());
            pStatement.setString(3, sql_a.getAnswer());
            pStatement.setInt(4, sql_a.getIndex());
            pStatement.executeUpdate();
            return true;
        } 
        catch (SQLException e) 
        {
            return false;
        }
    }

    public List<SQL_Q> getQuestionsByCategory(String category) 
    {
        List<SQL_Q> questions = new ArrayList<>();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from QUESTIONS where CATEGORY=?");
            pStatement.setString(1, category);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) 
            {
                SQL_Q sql_q = new SQL_Q();
                sql_q.setCode(rs.getString("CODE"));
                sql_q.setType(rs.getInt("TYPE"));
                sql_q.setDifficulty(rs.getInt("DIFFICULTY"));
                sql_q.setQuestion(rs.getString("QUESTION"));
                sql_q.setCategory(rs.getString("CATEGORY"));
                questions.add(sql_q);
            }
        }
        catch (SQLException e) {}
        return questions;
    }
    
    public List<SQL_Q> get_ALL_questions() 
    {
        List<SQL_Q> questions = new ArrayList<>();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from QUESTIONS");
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) 
            {
                SQL_Q sql_q = new SQL_Q();
                sql_q.setCode(rs.getString("CODE"));
                sql_q.setType(rs.getInt("TYPE"));
                sql_q.setDifficulty(rs.getInt("DIFFICULTY"));
                sql_q.setQuestion(rs.getString("QUESTION"));
                sql_q.setCategory(rs.getString("CATEGORY"));
                questions.add(sql_q);
            }
        }
        catch (SQLException e) {}
        return questions;
    }
    
    public List<SQL_Q> getByManyCategoris(String[] categoris)
    {
        List<SQL_Q> temp = new ArrayList<>();
        for (String categori : categoris) 
        {
            List<SQL_Q> t = getQuestionsByCategory(categori);
            temp.addAll(t);
        }
        return temp;
    }
    
    public List<SQL_Q> getQ_Category_and_Difficulty(String category,int difficulty) 
    {
        List<SQL_Q> questions = new ArrayList<>();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from QUESTIONS where CATEGORY=? and DIFFICULTY=?");
            pStatement.setString(1, category);
            pStatement.setInt(2, difficulty);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) 
            {
                SQL_Q sql_q = new SQL_Q();
                sql_q.setCode(rs.getString("CODE"));
                sql_q.setType(rs.getInt("TYPE"));
                sql_q.setDifficulty(rs.getInt("DIFFICULTY"));
                sql_q.setQuestion(rs.getString("QUESTION"));
                sql_q.setCategory(rs.getString("CATEGORY"));
                questions.add(sql_q);
            }
        }
        catch (SQLException e) {}
        return questions;
    }
    
    public List<SQL_Q> get_manyQ_Category_difficulty(String[] categoris,int difficulty)
    {
        List<SQL_Q> temp = new ArrayList<>();
        for (String categori : categoris) 
        {
            List<SQL_Q> t = getQ_Category_and_Difficulty(categori,difficulty);
            temp.addAll(t);
        }
        return temp;
    }

    public SQL_Q getSQL_Q(String Q_code) 
    {
        SQL_Q sql_q = new SQL_Q();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from QUESTIONS where CODE=?");
            pStatement.setString(1, Q_code);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) 
            {
                sql_q.setCode(rs.getString("CODE"));
                sql_q.setType(rs.getInt("TYPE"));
                sql_q.setDifficulty(rs.getInt("DIFFICULTY"));
                sql_q.setQuestion(rs.getString("QUESTION"));
                sql_q.setCategory(rs.getString("CATEGORY"));
            }
        }
        catch (SQLException e) {}
        return sql_q;
    }
    
    public SQL_A getSQL_A(String Q_code) 
    {
        SQL_A sql_a = new SQL_A();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from ANSWERS where CODE=?");
            pStatement.setString(1, Q_code);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) 
            {
                sql_a.setCode(rs.getString("CODE"));
                sql_a.setType(rs.getInt("TYPE"));
                sql_a.setAnswer(rs.getString("ANSWER"));
                sql_a.setIndex(rs.getInt("INDEX"));
            }
        }
        catch (SQLException e) {}
        return sql_a;
    }
    
    public List<SQL_A> getSQL_Answers(String Q_code)
    {
        List<SQL_A> answers = new ArrayList<>();
        try 
        {
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("select * from ANSWERS where CODE=?");
            pStatement.setString(1, Q_code);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) 
            {
                SQL_A sql_a = new SQL_A();
                sql_a.setCode(rs.getString("CODE"));
                sql_a.setType(rs.getInt("TYPE"));
                sql_a.setAnswer(rs.getString("ANSWER"));
                sql_a.setIndex(rs.getInt("INDEX"));
                answers.add(sql_a);
            }
        }
        catch (SQLException e) {}
        return answers;
    }

}
