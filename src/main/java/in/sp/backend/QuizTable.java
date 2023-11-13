package in.sp.backend;

import java.io.IOException;
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
@WebServlet("/quizlist")
public class QuizTable extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession hs=req.getSession();
         
 	      String username=(String)hs.getAttribute("username");       
 		   try {
 			   Class.forName("com.mysql.cj.jdbc.Driver");
 		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
 		  		String query1="select * from quizlist where username='"+username+"'";
 		  		PreparedStatement ps=con.prepareStatement(query1);
 		  		ResultSet rs= ps.executeQuery();
 		  		String  data="<table align='center' border='1' bgcolor='lightblue'>";
                data=data+"<th>USERNAME</th><th>QUIZ NAME</th><th>Q_ID</th>";
                if(rs!=null){
                   while(rs.next()){
                       data=data+"<tr>";
                    
                           data=data+"<td>"+rs.getString(1)+"</td>";
                           data=data+"<td>"+rs.getString(2)+"</td>";
                           data=data+"<td>"+rs.getString(3)+"</td>";
                           
                       data=data+"</tr>";
                   }
                   data=data+"</table>";
                }
                else {
                	data="No quiz available";
                }
                hs.setAttribute("quiz_table",data );
                RequestDispatcher rd=req.getRequestDispatcher("/viewquizlist.jsp");
  	   			rd.include(req, resp);
                   
 		   }catch(Exception e){
 			    resp.setContentType("text/html");
				
				String data=e.getMessage();
				hs.setAttribute("quiz_table", data);
				RequestDispatcher rd=req.getRequestDispatcher("/viewquizlist.jsp");
				rd.include(req, resp);
 		   }
    }
}
