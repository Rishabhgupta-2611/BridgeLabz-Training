package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "admin123".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);

            out.println("<html>");
            out.println("<head><title>Login Success</title></head>");
            out.println("<body>");

            out.println("<h1>Login Successful</h1>");
            out.println("<p>Welcome, " + username + "!</p>");

            out.println("<a href='logout'>Logout</a>");

            out.println("</body>");
            out.println("</html>");

        } else {

            out.println("<html>");
            out.println("<head><title>Login Failed</title></head>");
            out.println("<body>");

            out.println("<h1>Login Failed</h1>");
            out.println("<p>Invalid username or password.</p>");

            out.println("<a href='login.html'>Try Again</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}