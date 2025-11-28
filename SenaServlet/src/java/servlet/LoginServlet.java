package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write("{\"message\":\"Login API - Usa POST\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String documento = request.getParameter("documento");

        PrintWriter out = response.getWriter();

        try {
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT nombre FROM usuario WHERE email = ? AND documento = ?"
            );
            ps.setString(1, email);
            ps.setString(2, documento);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Crear sesión
                HttpSession sesion = request.getSession();
                sesion.setAttribute("nombre", rs.getString("nombre"));

                // RESPUESTA JSON EXITOSA
                out.print("{\"status\":\"ok\", \"message\":\"Login correcto\", \"nombre\":\"" 
                         + rs.getString("nombre") + "\"}");
            } else {
                // RESPUESTA JSON DE ERROR
                out.print("{\"status\":\"error\", \"message\":\"Credenciales incorrectas\"}");
            }

        } catch (Exception e) {
            out.print("{\"status\":\"error\", \"message\":\"Error en servidor\"}");
            e.printStackTrace();
        }
        
    }
}
