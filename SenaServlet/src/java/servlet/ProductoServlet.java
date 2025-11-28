package servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
        int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));

        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO producto (nombre, descripcion, precio, stock, categoria_id, proveedor_id) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setInt(4, stock);
            ps.setInt(5, categoria_id);
            ps.setInt(6, proveedor_id);
            ps.executeUpdate();

            response.sendRedirect("dashboard.jsp?msg=producto_ok");
        } catch (SQLException e) {
            throw new ServletException("Error al registrar producto", e);
        }
    }
}

