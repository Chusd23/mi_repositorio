package sena.codejava.minimercado.model;
import jakarta.persistence.*;

@Entity                     // Indica que esta clase será una tabla en la BD
@Table(name = "producto")  // Nombre de la tabla en MySQL
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental en MySQL
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    @Column(name = "categoria_id", nullable = true)
    private Integer categoriaId;
    @Column(name = "proveedor_id", nullable = true)
    private Integer proveedorId;

    // Constructor vacío (obligatorio para JPA)
    public Producto() {}

    // Constructor sin ID (para nuevos productos)
    public Producto(String nombre, String descripcion, double precio, int stock,
                    Integer categoriaId, Integer proveedorId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
    }

    // Constructor con ID (opcional)
    public Producto(int id, String nombre, String descripcion, double precio, int stock,
                    Integer categoriaId, Integer proveedorId) {
        this(nombre, descripcion, precio, stock, categoriaId, proveedorId);
        this.id = id;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public Integer getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Integer categoriaId) { this.categoriaId = categoriaId; }

    public Integer getProveedorId() { return proveedorId; }
    public void setProveedorId(Integer proveedorId) { this.proveedorId = proveedorId; }
}
