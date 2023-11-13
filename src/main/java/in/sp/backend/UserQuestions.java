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
@WebServlet("/userquestions")
public class UserQuestions extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession hs=req.getSession();
         
 	      String username=(String)hs.getAttribute("username");  
 	      String q_id=(String)hs.getAttribute("q_id");
 	      String data="";
 		   try {
 			   Class.forName("com.mysql.cj.jdbc.Driver");
 		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
 		  		String query1="select * from "+q_id;
 		  		PreparedStatement ps=con.prepareStatement(query1);
 		  		ResultSet rs= ps.executeQuery();
 		  		
 		  		
                    
 	 		  	   int i=1;
                   while(rs.next()){
                       
                     
                     data=data+"<label>"+i+") "+rs.getString(1)+"</label>";
                     data=data+"<label>"+rs.getString(2)+"</label>";
                     data=data+"<input type='text' name='answer"+i+"' placeholder='Your answer' input>";    
                      i++;   
                    
                   }
                  
                
              
                hs.setAttribute("user_quiz_table",data );
                hs.setAttribute("total", i-1);
                RequestDispatcher rd=req.getRequestDispatcher("/ExamPage.jsp");
  	   			rd.include(req, resp);
                   
 		   }catch(Exception e){
 			    resp.setContentType("text/html");
				
				data=e.getMessage();
				hs.setAttribute("user_quiz_table", data);
				RequestDispatcher rd=req.getRequestDispatcher("/ExamPage.jsp");
				rd.include(req, resp);
 		   }
    }
}
