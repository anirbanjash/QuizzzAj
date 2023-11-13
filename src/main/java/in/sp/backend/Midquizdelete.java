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
@WebServlet("/midquizdelete")
public class Midquizdelete extends HttpServlet{
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 HttpSession hs=req.getSession();
    	 PrintWriter out=resp.getWriter(); 
    	 String q_id=(String)hs.getAttribute("q_id");

        
         try {
     		Class.forName("com.mysql.cj.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
            PreparedStatement ps=con.prepareStatement("drop table "+q_id);
          
            ps.executeUpdate();
            PreparedStatement ps1=con.prepareStatement("delete  from quizlist where q_id='"+q_id+"'");
            ps1.executeUpdate();
            
  			hs.invalidate();
  	        RequestDispatcher rd = req.getRequestDispatcher("/createquiz.jsp");
  	        rd.forward(req, resp);
     		
            }
         catch(Exception e) {
        	resp.setContentType("text/html");
        	String msg=e.getMessage();
        	hs.setAttribute("mui", msg);
  			RequestDispatcher rd=req.getRequestDispatcher("/createquiz.jsp");
  			rd.include(req, resp);
         }
}
}
