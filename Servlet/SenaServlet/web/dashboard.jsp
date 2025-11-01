<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Producto - Minimercado</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            margin: 0;
            background: linear-gradient(135deg, #bde0fe, #e3f2fd);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-container {
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.2);
            width: 420px;
        }

        h2 {
            text-align: center;
            color: #0077b6;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #333;
        }

        input, select, textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-top: 5px;
            font-size: 14px;
        }

        button {
            width: 100%;
            background: #0077b6;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 6px;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            transition: background 0.3s;
        }

        button:hover {
            background: #005f99;
        }

        .mensaje {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: green;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <%
            HttpSession sesion = request.getSession(false);
            if (sesion == null || sesion.getAttribute("nombre") == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>

        <h2>Registrar Producto</h2>

        <form action="ProductoServlet" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required>

            <label for="descripcion">Descripción:</label>
            <textarea name="descripcion" rows="3"></textarea>

            <label for="precio">Precio:</label>
            <input type="number" step="0.01" name="precio" required>

            <label for="stock">Stock:</label>
            <input type="number" name="stock" required>

            <label for="categoria_id">ID Categoría:</label>
            <input type="number" name="categoria_id" required>

            <label for="proveedor_id">ID Proveedor:</label>
            <input type="number" name="proveedor_id" required>

            <button type="submit">Guardar Producto</button>
        </form>

        <% if (request.getParameter("success") != null) { %>
            <div class="mensaje exito">Producto agregado correctamente.</div>
        <% } else if (request.getParameter("error") != null) { %>
            <div class="mensaje error">Error al registrar el producto.</div>
        <% } %>
    </div>

</body>
</html>



