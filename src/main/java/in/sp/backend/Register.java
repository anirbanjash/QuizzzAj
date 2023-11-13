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

@WebServlet("/registrationFormadmin")
public class Register extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        String message="";
        PrintWriter out = resp.getWriter();
        String myname = req.getParameter("name");
        String password=req.getParameter("password");
        String confirmpass=req.getParameter("confirmPassword");
        long ph_number = Long.parseLong(req.getParameter("phoneNumber"));
        String[] nameParts = myname.split("\\s");
        String usn=nameParts[0] + String.valueOf(ph_number);
        String username=req.getParameter("username");
       
        if (String.valueOf(ph_number).length()>10 || String.valueOf(ph_number).length()<10) {
            resp.setContentType("text/html");
            message = "<h3 style='color:red'>Please enter correct phone number </h3>";
            hs.setAttribute("m", message);
            RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
            rd.include(req, resp);
            return;
            
        }else {
        	
        	 if (password.equals(confirmpass)==false) {
        		 
                 resp.setContentType("text/html");
                 message = "<h3 style='color:red'>Your password and confirm password is not matched</h3>";
                 hs.setAttribute("m", message);
                 RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
                 rd.include(req, resp);
                 return;
                 
             }
        	 else {
        		 
        		 if (usn.equalsIgnoreCase(username)==false) {
                     resp.setContentType("text/html");
                     message = "<h3 style='color:red'>Your Username  is not  correct </h3>";
                     hs.setAttribute("m", message);
                     RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
                     rd.include(req, resp);
                     return;
                     
                 } 
        		 else {
        			 
	        		 try {
	        			 Class.forName("com.mysql.cj.jdbc.Driver");
	                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anirban@2001");
	                     PreparedStatement ps = con.prepareStatement("select * from admintable where username=?");
	                     ps.setString(1,username);
	                     ResultSet rs= ps.executeQuery();
	                     if(rs.next()) {
	                    	 resp.setContentType("text/html");
	                         message = "<h3 style='color:red'>This username is already registerd </h3>";
	                         hs.setAttribute("m", message);
	                         RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
	                         rd.include(req, resp);
	                         return; 
	                     }
	                     else {
	                     PreparedStatement ps1 = con.prepareStatement("insert into admintable values (?,?,?,?)");
	                     ps1.setString(1, myname);
	                     ps1.setLong(2, ph_number);
	                     ps1.setString(3, username);
	                     ps1.setString(4, password);
	                     int count = ps1.executeUpdate();
	                     
	                     if (count > 0) {
	                         resp.setContentType("text/html");
	                         message = "<h3 style='color:green'>Admin Registered Successfully </h3>";
	                         hs.setAttribute("m", message);
	                         RequestDispatcher rd = req.getRequestDispatcher("/adminLogin.jsp");
	                         rd.include(req, resp);
	                     } else {
	                         resp.setContentType("text/html");
	                         message = "<h3 style='color:red'>User not Registered Successfully due to some error </h3>";
	                         hs.setAttribute("m", message);
	                         RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
	                         rd.include(req, resp);
	                     }
	                     
	                     }
	             	}catch (Exception e) {
	             		 e.printStackTrace();
	                     resp.setContentType("text/html");
	                     message = e.getMessage();
	                     hs.setAttribute("m", message);
	                     RequestDispatcher rd = req.getRequestDispatcher("/adminRegister.jsp");
	                     rd.include(req, resp);
	     			}
        	 }
        	
        }
        }
}
}
