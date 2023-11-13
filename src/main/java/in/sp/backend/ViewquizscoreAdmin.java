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
@WebServlet("/adminscore")
public class ViewquizscoreAdmin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession hs=req.getSession();
         
 	      String username=(String)hs.getAttribute("username");  
 	      String q_id=req.getParameter("q_id");
 	      String data="";
 		   try {
 			   Class.forName("com.mysql.cj.jdbc.Driver");
 		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
 		  		String query1="select * from quizlist where username='"+username+"' and q_id= '"+q_id+"'";
 		  		PreparedStatement ps=con.prepareStatement(query1);
 		  		ResultSet rs= ps.executeQuery();
 		  		if(rs.next()) {
 		  			String query2="select * from quiz_score_check where q_id= '"+q_id+"'";
 	 		  		PreparedStatement ps1=con.prepareStatement(query2);
 	 		  		ResultSet rs1= ps1.executeQuery();
	 		  	    data="<table align='center' border='1' bgcolor='lightblue'>";
                    data=data+"<th>Name</th><th>Phone_Number</th><th>Q_ID</th><th>Score</th><th>Grade</th><th>Submission Time</th>";
                if(rs1!=null){
                   while(rs1.next()){
                       data=data+"<tr>";
                    
                           data=data+"<td>"+rs1.getString(1)+"</td>";
                           data=data+"<td>"+rs1.getLong(2)+"</td>";
                           data=data+"<td>"+rs1.getString(3)+"</td>";
                           data=data+"<td>"+rs1.getInt(4)+"</td>";
                           data=data+"<td>"+rs1.getString(5)+"</td>";
                           data=data+"<td>"+rs1.getString(6)+"</td>";
                           
                       data=data+"</tr>";
                   }
                   data=data+"</table>";
                }
                else {
                	data="Till now no history";
                	 hs.setAttribute("score_table",data );
                     RequestDispatcher rd=req.getRequestDispatcher("/AdminQuizscore.jsp");
       	   			 rd.include(req, resp);
       	   			 return;
                }
 		  		}else {
 		  			data="Invalis q_id";
 		  		 hs.setAttribute("score_table",data );
                 RequestDispatcher rd=req.getRequestDispatcher("/AdminQuizscore.jsp");
   	   			 rd.include(req, resp);
   	   			 return;
 		  		}
 		  		
                hs.setAttribute("score_table",data );
                RequestDispatcher rd=req.getRequestDispatcher("/AdminQuizscore.jsp");
  	   			rd.include(req, resp);
                   
 		   }catch(Exception e){
 			    resp.setContentType("text/html");
				
				data=e.getMessage();
				hs.setAttribute("score_table", data);
				RequestDispatcher rd=req.getRequestDispatcher("/AdminQuizscore.jsp");
				rd.include(req, resp);
 		   }
    }
}
