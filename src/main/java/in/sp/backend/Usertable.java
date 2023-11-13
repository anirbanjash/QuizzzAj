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
@WebServlet("/usertable")
public class Usertable extends HttpServlet{
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 HttpSession hs=req.getSession();
    	 PrintWriter out=resp.getWriter(); 
    	 String myname= req.getParameter("myname");

         long ph_no=Long.parseLong(req.getParameter("phone"));
         String q_id=req.getParameter("q_id");
         String message="";
         if (String.valueOf(ph_no).length()>10 || String.valueOf(ph_no).length()<10) {
             resp.setContentType("text/html");
             message = "<h3 style='color:red'>Please enter correct phone number </h3>";
             hs.setAttribute("mui", message);
             RequestDispatcher rd = req.getRequestDispatcher("/UserRegister.jsp");
             rd.include(req, resp);
             return;
         }
         else {
         try {
     		Class.forName("com.mysql.cj.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
     		PreparedStatement ps4=con.prepareStatement("select * from quizlist where q_id=?");
     		ps4.setString(1, q_id);
     		ResultSet rs4=ps4.executeQuery();
     		
     		if(rs4.next()) {
     	    hs.setAttribute("quiz_name", rs4.getString(2));
     		PreparedStatement ps=con.prepareStatement("select * from quiz_entry where phone_number=? and q_id=?");
     		ps.setLong(1, ph_no);
     		ps.setString(2, q_id);
     		ResultSet rs=ps.executeQuery();
     		if(rs.next()) {
     			  resp.setContentType("text/html");
                  message = "<h3 style='color:green'>You have already submitted</h3>";
                  hs.setAttribute("mui", message);
                  RequestDispatcher rd = req.getRequestDispatcher("/UserRegister.jsp");
                  rd.include(req, resp);
                  return;
     			
     		}else {
     			 
     			 PreparedStatement ps1=con.prepareStatement("INSERT INTO QUIZ_ENTRY VALUES (?,?,?)");
         		 ps1.setString(1,myname);
         		 ps1.setLong(2, ph_no);
         		 ps1.setString(3, q_id);
         		          		 
         		 int count=ps1.executeUpdate();
         		 if(count!=0) {
         			hs.setAttribute("q_id", q_id);
         			hs.setAttribute("ph_no", ph_no);
         			hs.setAttribute("myname", myname);
         			RequestDispatcher rd = req.getRequestDispatcher("/Start1.jsp");
                    rd.include(req, resp);
         		 }
     			
     		}
     		
            }else {
            	 resp.setContentType("text/html");
                 message = "<h3 style='color:red'>Wrong Q_ID </h3>";
                 hs.setAttribute("mui", message);
                 RequestDispatcher rd = req.getRequestDispatcher("/UserRegister.jsp");
                 rd.include(req, resp);
            }
         }
         catch(Exception e) {
        	resp.setContentType("text/html");
        	String msg=e.getMessage();
        	hs.setAttribute("mui", msg);
  			RequestDispatcher rd=req.getRequestDispatcher("/UserRegister.jsp");
  			rd.include(req, resp);
         }
}
}
}