package zhoujingkai.week3.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.System.out;

@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    java.sql.Connection con=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        ServletContext context = getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username1=context.getInitParameter("username");
        String password1=context.getInitParameter("password");
        try{
            Class.forName(driver);
            con=  DriverManager.getConnection(url,username1,password1);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email= request.getParameter("email");
        String gender= request.getParameter("gender");
        String birthdate= request.getParameter("birthdate");

        String sql = "INSERT INTO usertable (id,username, password,email,gender,birthdate) VALUES (?,?, ?,?,?,?)";
        try {

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setString(5, gender);
            statement.setString(6, birthdate);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void init() throws ServletException{
        ServletContext context = getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try{
            Class.forName(driver);
            con=  DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
