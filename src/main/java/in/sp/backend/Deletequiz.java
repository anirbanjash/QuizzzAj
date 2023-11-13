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

@WebServlet("/deletequiz")
public class Deletequiz extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        PrintWriter out = resp.getWriter();
        String q_id = req.getParameter("q_id");
        String username = (String) hs.getAttribute("username");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "Anirban@2001");

            // Use consistent case for column and table names
            String query1 = "SELECT * FROM quizlist WHERE username='" + username + "' AND Q_id= '" + q_id + "'";
            PreparedStatement ps2 = con.prepareStatement(query1);
            ResultSet rs = ps2.executeQuery();

            // Check if there are rows returned
            if (rs.next()) {
                PreparedStatement ps = con.prepareStatement("DROP TABLE " + q_id);
                ps.executeUpdate();

                PreparedStatement ps1 = con.prepareStatement("DELETE FROM quizlist WHERE Q_id='" + q_id + "'");
                int count = ps1.executeUpdate();

                if (count != 0) {
                    String msg = "Table deleted";
                    hs.setAttribute("wrong", msg);
                    RequestDispatcher rd = req.getRequestDispatcher("/DeleteQuiz.jsp");
                    rd.include(req, resp);
                } else {
                    String msg = "Table Not deleted";
                    hs.setAttribute("wrong", msg);
                    RequestDispatcher rd = req.getRequestDispatcher("/DeleteQuiz.jsp");
                    rd.include(req, resp);
                }
            } else {
                String msg = "Wrong Q_ID";
                hs.setAttribute("wrong", msg);
                RequestDispatcher rd = req.getRequestDispatcher("/DeleteQuiz.jsp");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            resp.setContentType("text/html");
            String msg = e.getMessage();
            hs.setAttribute("mui", msg);
            RequestDispatcher rd = req.getRequestDispatcher("/DeleteQuiz.jsp");
            rd.include(req, resp);
        }
    }
}
