package overweight.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
  
public class WelcomeServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");  
//    out.print("Welcome "+n);  
    RequestDispatcher rd=request.getRequestDispatcher("home.html");
    //response.sendRedirect("welcome.html");
    rd.include(request,response); 
    out.close();  
    }  
  
} 