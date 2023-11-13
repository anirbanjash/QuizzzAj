package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/adminLoginForm")
public class adminLogin extends HttpServlet{
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 HttpSession hs=req.getSession();
    	 PrintWriter out=resp.getWriter(); 
    	 String uname= req.getParameter("adminUsername");

         String password=req.getParameter("password");
         
         try {
     		Class.forName("com.mysql.cj.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
     		PreparedStatement ps=con.prepareStatement("select * from admintable where username=? and password=?");
     		
     		ps.setString(1, uname);
     		ps.setString(2, password);
     		
     		ResultSet rs=ps.executeQuery();
     		
     		if(rs.next()) {
     			
     			hs.setAttribute("name", rs.getString("name"));
     			hs.setAttribute("username", uname);
     			
     			RequestDispatcher rd=req.getRequestDispatcher("/createquiz.jsp");
     			rd.include(req, resp);
     			
     		}else {
     			resp.setContentType("text/html");
     			String msg="<h3 style='color:red'>Invalid username and password </h3>";
     			hs.setAttribute("messa", msg);
     			RequestDispatcher rd=req.getRequestDispatcher("/adminLogin.jsp");
     			rd.include(req, resp);
     		}
     		
            }
         catch(Exception e) {
        	resp.setContentType("text/html");
        	String msg=e.getMessage();
        	hs.setAttribute("messa", msg);
  			RequestDispatcher rd=req.getRequestDispatcher("/adminLogin.jsp");
  			rd.include(req, resp);
         }
}
}
