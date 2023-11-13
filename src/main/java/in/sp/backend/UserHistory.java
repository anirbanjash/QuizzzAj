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
@WebServlet("/userhistory")
public class UserHistory extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession hs=req.getSession();
         
 	      String username=(String)hs.getAttribute("username");  
 	      String q_id=req.getParameter("q_id_name");
 	      String data="";
 	      long ph_no=Long.parseLong(req.getParameter("ph_no"));
 		   try {
 			   Class.forName("com.mysql.cj.jdbc.Driver");
 		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
 	
 		  		PreparedStatement ps=con.prepareStatement("select * from quiz_score_check where phone_number=?");
 		  		ps.setLong(1,ph_no);
 		  		ResultSet rs1= ps.executeQuery();
 		  		
 		  		
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
                	data="No History available";
                	 hs.setAttribute("hist_table",data );
                     RequestDispatcher rd=req.getRequestDispatcher("/Userhistory.jsp");
       	   			 rd.include(req, resp);
       	   			 return;
                }
 		  		
 		  		
                hs.setAttribute("hist_table",data );
                RequestDispatcher rd=req.getRequestDispatcher("/Userhistory.jsp");
  	   			rd.include(req, resp);
                   
 		   }catch(Exception e){
 			    resp.setContentType("text/html");
				
				data=e.getMessage();
				hs.setAttribute("hist_table", data);
				RequestDispatcher rd=req.getRequestDispatcher("/UserRegister.jsp");
				rd.include(req, resp);
 		   }
    }
}
