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

@WebServlet("/questionadd")
public class Questions extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        PrintWriter out = resp.getWriter();
        String ques = req.getParameter("question");
        String op1 = req.getParameter("option1");
        String op2 = req.getParameter("option2");
        String op3 = req.getParameter("option3");
        String op4 = req.getParameter("option4");
        String answer = req.getParameter("answer");
        String optionsall = "1." + op1 + "  2." + op2 + "  3." + op3 + "  4." + op4;
        String q_id = (String) hs.getAttribute("q_id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anirban@2001");
            
            // Inserting data into the table
            String insertDataQuery = "INSERT INTO " + q_id + " VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertDataQuery);
            ps.setString(1, ques);
            ps.setString(2, optionsall);
            ps.setString(3, answer);
            int c = ps.executeUpdate();

            if (c != 0) {
                // Retrieving the count after insertion
                PreparedStatement ps1 = con.prepareStatement("SELECT COUNT(*) FROM " + q_id);
                ResultSet rs = ps1.executeQuery();

                // Move the cursor to the first row
                if (rs.next()) {
                    int q_no = rs.getInt(1) + 1;
                    
//                    if(q_no==11) {
//                    	 hs.setAttribute("q_no", 10);
//                    	 RequestDispatcher rd = req.getRequestDispatcher("/Examlastpageprev.jsp");
//                         rd.include(req, resp);
//                         return;
//                    }
                    hs.setAttribute("q_no", q_no);
                    RequestDispatcher rd = req.getRequestDispatcher("/Questions.jsp");
                    rd.include(req, resp);
                    
                } else {
                    resp.setContentType("text/html");
                    String msg = "<h3 style='color:red'>Something error </h3>";
                    hs.setAttribute("me", msg);
                    RequestDispatcher rd = req.getRequestDispatcher("/Questions.jsp");
                    rd.include(req, resp);
                }
            } else {
                resp.setContentType("text/html");
                String msg = "<h3 style='color:red'>Something error </h3>";
                hs.setAttribute("me", msg);
                RequestDispatcher rd = req.getRequestDispatcher("/Questions.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            resp.setContentType("text/html");
            String msg = e.getMessage();
            hs.setAttribute("me", msg);
            RequestDispatcher rd = req.getRequestDispatcher("/Questions.jsp");
            rd.include(req, resp);
        }
    }
}
