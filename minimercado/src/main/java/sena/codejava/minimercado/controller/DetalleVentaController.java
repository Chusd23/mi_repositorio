package sena.codejava.minimercado.controller;

import org.springframework.web.bind.annotation.*;
import sena.codejava.minimercado.model.DetalleVenta;
import sena.codejava.minimercado.repository.DetalleVentaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/detalleventas")
@CrossOrigin("*")
public class DetalleVentaController {

    private final DetalleVentaRepository repo;

    public DetalleVentaController(DetalleVentaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<DetalleVenta> listar() {
        return repo.findAll();
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalle) {
        return repo.save(detalle);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        repo.deleteById(id);
    }
}

