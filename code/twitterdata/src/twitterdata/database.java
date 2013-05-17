/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package twitterdata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
public class database {

    public static void main(String[] args)throws Exception
    {
    Connection connection=getConnection();
    Statement st=null;
    ResultSet rs=null;
    try{
    st=connection.createStatement();
    rs=st.executeQuery("select count(*) from ngram ");
    rs.next();
    int count=rs.getInt(1);
    System.out.println("employee count "+count);




    }
    finally{
    if(st!=null)
    {

    st.close();
    }

    }


    }
    public static Connection getConnection()
    {
    Connection con=null;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","akshay");
    }
    catch(SQLException ex)
    {
    ex.printStackTrace();
    }
    catch(ClassNotFoundException ex)
    {
    ex.printStackTrace();
    }
    return con;
    }




    }


