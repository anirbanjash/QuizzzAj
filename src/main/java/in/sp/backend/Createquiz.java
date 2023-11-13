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
@WebServlet("/createquiz")
public class Createquiz extends HttpServlet{
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 HttpSession hs=req.getSession();
    	 PrintWriter out=resp.getWriter(); 
         String username =(String)hs.getAttribute("username");
         String examname=req.getParameter("examTopic");
         hs.setAttribute("exam_name",examname);
         try {
     		Class.forName("com.mysql.cj.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
     		PreparedStatement ps=con.prepareStatement("select COUNT(*) from quizlist");
     		ResultSet rs=ps.executeQuery();
     		if(rs.next()) {	
     		int count=rs.getInt(1);
     		String q_id=examname+String.valueOf(count+1);
     		PreparedStatement ps3=con.prepareStatement("select * from quizlist where Q_id = ?");
     		ps3.setString(1, q_id) ;
     		ResultSet rs1=ps3.executeQuery();
     		
     		if(rs1.next()) {
     			q_id=q_id+"xe";
     		}
     		hs.setAttribute("q_id",q_id);
     		
     		PreparedStatement ps1=con.prepareStatement("INSERT INTO QUIZLIST VALUES(?,?,?)");
     		ps1.setString(1,username);
     		ps1.setString(2, examname);
     		ps1.setString(3, q_id);
     		int c=ps1.executeUpdate();
     		if(c!=0) {
     			String createTableQuery = "CREATE TABLE " + q_id + " (questions varchar(200), options varchar(200), answer varchar(100))";
     			PreparedStatement ps2 = con.prepareStatement(createTableQuery);
     			ps2.executeUpdate();

     			RequestDispatcher rd=req.getRequestDispatcher("/Questions.jsp");
     			rd.include(req, resp);
     		}
     		else {
     			resp.setContentType("text/html");
     			String msg="<h3 style='color:red'>Something is error </h3>";
     			hs.setAttribute("mes", msg);
     			RequestDispatcher rd=req.getRequestDispatcher("/createquiz.jsp");
     			rd.include(req, resp);
     		}
     		
     		}
     		else {
     			resp.setContentType("text/html");
     			String msg="<h3 style='color:red'>Something is wrong</h3>";
     			hs.setAttribute("mes", msg);
     			RequestDispatcher rd=req.getRequestDispatcher("/createquiz.jsp");
     			rd.include(req, resp);
     		}
     		
            }
         catch(Exception e) {
        	resp.setContentType("text/html");
        	String msg=e.getMessage();
        	hs.setAttribute("mes", msg);
  			RequestDispatcher rd=req.getRequestDispatcher("/createquiz.jsp");
  			rd.include(req, resp);
         }
}
}
