package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String documento = request.getParameter("documento");

        try (Connection con = Conexion.getConnection()) {
            String sql = "SELECT * FROM usuario WHERE email=? AND documento=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, documento);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("nombre", rs.getString("nombre"));
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp?error=1");
            }
        } catch (SQLException e) {
            throw new ServletException("Error en LoginServlet", e);
        }
    }
}
