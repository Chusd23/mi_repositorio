<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión - Minimercado</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background: linear-gradient(135deg, #bde0fe, #e3f2fd);
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-box {
            background: white;
            padding: 40px 50px;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.2);
            width: 380px;
            text-align: center;
        }

        h2 {
            color: #0077b6;
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 15px;
        }

        button {
            width: 100%;
            background: #0077b6;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 8px;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            transition: background 0.3s;
        }

        button:hover {
            background: #005f99;
        }

        .error {
            color: red;
            margin-top: 15px;
            font-size: 14px;
        }

        footer {
            position: absolute;
            bottom: 10px;
            width: 100%;
            text-align: center;
            color: #333;
            font-size: 13px;
        }
    </style>
</head>
<body>

    <div class="login-box">
        <h2>Iniciar Sesión</h2>
        <form action="LoginServlet" method="post">
            <input type="email" name="email" placeholder="Correo electrónico" required>
            <input type="text" name="documento" placeholder="Documento" required>
            <button type="submit">Ingresar</button>
        </form>

        <% if (request.getParameter("error") != null) { %>
            <p class="error">Credenciales incorrectas. Intenta de nuevo.</p>
        <% } %>
    </div>

    <footer>
        Minimercado SENA  2025 - Sistema de Inventario
    </footer>

</body>
</html>


