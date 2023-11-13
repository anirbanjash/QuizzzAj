package in.sp.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/result")
public class Result extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          HttpSession hs=req.getSession();
         
 	      String myname=(String)hs.getAttribute("myname")  ;
 	      String q_id=(String)hs.getAttribute("q_id");
 	      Long ph_no=(long)(hs.getAttribute("ph_no"));
 	      String score_an="";
 	      String data="";
 	      
 		   try {
 			   Class.forName("com.mysql.cj.jdbc.Driver");
 		  		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","Anirban@2001");
 		  		String query1="select * from "+q_id;
 		  		PreparedStatement ps=con.prepareStatement(query1);
 		  		ResultSet rs= ps.executeQuery();
 		  		int score=0;
 		  		int total=0;
 		  		  
                    
 		  			int i=1;
                   while(rs.next()){
                	   
                     if(rs.getString(3).equalsIgnoreCase(req.getParameter("answer"+i))){
                    	score=score+10; 
                     }
                     total=total+10;
                     i++;
                   }
                   String query2 = "select * from " + q_id;
                   PreparedStatement ps1 = con.prepareStatement(query2);
                   ResultSet rs2 = ps1.executeQuery();
                   data="<table align='center' border='1' bgcolor='lightblue'>";
                   data=data+"<th>QUESTION</th><th>OPTION</th><th>ANSWER</th>";
                   while(rs2.next()){
                       data=data+"<tr>";
                    
                           data=data+"<td>"+rs2.getString(1)+"</td>";
                           data=data+"<td>"+rs2.getString(2)+"</td>";
                           data=data+"<td>"+rs2.getString(3)+"</td>";
                           
                       data=data+"</tr>";
                   }
                   data=data+"</table>";
                  
               
                int percentage = (int) (((double) score / total) * 100);

 		  		if(percentage<=40) {
 		  			 LocalDateTime currentDateTime = LocalDateTime.now();
 	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 	                 String formattedDateTime = currentDateTime.format(formatter);  
 		  			score_an="<h1 style='color:red'>Your score is :"+score+"/"+total+". FAIL </h1>";
 		  			PreparedStatement ps2=con.prepareStatement("Insert into quiz_score_check values (?,?,?,?,?,?,?)");
 		  			ps2.setString(1,myname);
 		  			ps2.setLong(2, ph_no);
 		  			ps2.setString(3,q_id);
 		  			ps2.setInt(4,score);
 		  			ps2.setInt(5, total);
 		  			ps2.setString(6,"FAIL");
 		  			ps2.setString(7,formattedDateTime);
 	 		  		int e= ps2.executeUpdate();
 	 		  		
 		  		}else if(percentage>40 && percentage<=70) {
 		  			LocalDateTime currentDateTime = LocalDateTime.now();
 	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 	                 String formattedDateTime = currentDateTime.format(formatter);  
 		  			score_an="<h1 style='color:blue'>Your score is :"+score+"/"+total +". PASS [Average] </h1>";
 		  			PreparedStatement ps2=con.prepareStatement("Insert into quiz_score_check values (?,?,?,?,?,?,?)");
 		  			ps2.setString(1,myname);
 		  			ps2.setLong(2, ph_no);
 		  			ps2.setString(3,q_id);
 		  			ps2.setInt(4,score);
 		  			ps2.setInt(5, total);
 		  			ps2.setString(6,"AVERAGE");
 		  			ps2.setString(7,formattedDateTime);
 	 		  		int e= ps2.executeUpdate();
 		  		}else {
 		  			LocalDateTime currentDateTime = LocalDateTime.now();
 	                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 	                 String formattedDateTime = currentDateTime.format(formatter);  
 		  			score_an="<h1 style='color:green'>Your score is :"+score+"/"+total+". PASS [Outstanding] </h1>";
 		  			PreparedStatement ps2=con.prepareStatement("Insert into quiz_score_check values (?,?,?,?,?,?,?)");
 		  			ps2.setString(1,myname);
 		  			ps2.setLong(2, ph_no);
 		  			ps2.setString(3,q_id);
 		  			ps2.setInt(4,score);
 		  			ps2.setInt(5, total);
 		  			ps2.setString(6,"OUTSTANDING");
 		  			ps2.setString(7,formattedDateTime);
 	 		  		int e= ps2.executeUpdate();
 		  		}
 		  		hs.setAttribute("score_res", score_an);
 		  		hs.setAttribute("miaaa",data );
 		  		RequestDispatcher rd=req.getRequestDispatcher("/Result.jsp");
				rd.include(req, resp); 
				
				
    
 		   }catch(Exception e){
 			    resp.setContentType("text/html");
				
				data=e.getMessage();
				hs.setAttribute("miaaa", data);
				RequestDispatcher rd=req.getRequestDispatcher("/Result.jsp");
				rd.include(req, resp);
 		   }
    }
}



