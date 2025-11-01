<html>
<head><title>Registrar Producto</title></head>
<body>
<h2>Nuevo Producto</h2>
<form action="ProductoServlet" method="post">
    <label>Nombre:</label><input type="text" name="nombre"><br>
    <label>Descripción:</label><input type="text" name="descripcion"><br>
    <label>Precio:</label><input type="number" step="0.01" name="precio"><br>
    <label>Stock:</label><input type="number" name="stock"><br>
    <label>ID Categoría:</label><input type="number" name="categoria_id"><br>
    <label>ID Proveedor:</label><input type="number" name="proveedor_id"><br>
    <input type="submit" value="Registrar">
</form>
</body>
</html>

