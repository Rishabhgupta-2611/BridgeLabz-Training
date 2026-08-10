package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Registration</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Registration Successful</h1>");

        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("<p>Your account has been created successfully.</p>");

        out.println("<a href='login.html'>Go to Login</a>");

        out.println("</body>");
        out.println("</html>");
    }
}