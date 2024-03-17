package zhoujingkai.week3.demo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//automatic -new --> servlet
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
        //request come here- <from method=post>
        //get parameter from request
        String username = request.getParameter("username");//name of input type-<input type="text" name="username"/><br/>
        String password = request.getParameter("password");//<input type="password" name="password"/>
        String email = request.getParameter("email");//<input type="text" name="email"/>
        String gender = request.getParameter("gender");//<input type="radio" name="gender">
        String birthDate = request.getParameter("birthDate");//<input type="text name=" name="birthDate">

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br> username :"+username);
        writer.println("<br> password :"+password);
        writer.println("<br> email :"+email);
        writer.println("<br> gender :"+gender);
        writer.println("<br> birth Date :"+birthDate);
        writer.close();
    }
}