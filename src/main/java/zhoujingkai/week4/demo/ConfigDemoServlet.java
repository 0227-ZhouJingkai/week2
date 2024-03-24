package zhoujingkai.week4.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ConfigDemoServlet")
public class ConfigDemoServlet extends HttpServlet {
    private String message;

    public void init() {
        // 初始化 message 变量
        message = "Hello, this is a servlet config demo.";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取 ServletConfig 参数
        String yourName = getServletConfig().getInitParameter("yourname1");
        String studentId = getServletConfig().getInitParameter("studentId1");

        // 设置响应内容类型
        response.setContentType("text/html");

        // 输出参数值到 response
        response.getWriter().println("<h1>Your Name1: " + yourName + "</h1>");
        response.getWriter().println("<h1>Your Student ID1: " + studentId + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 调用 doGet() 方法处理 POST 请求
        this.doGet(request, response);
    }
}
