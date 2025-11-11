package sena.codejava.minimercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import sena.codejava.minimercado.model.Producto;
import sena.codejava.minimercado.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Mostrar todos los productos
    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    // Crear nuevo producto
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto por id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        productoRepository.deleteById(id);
    }
}


