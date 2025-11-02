package sena.codejava.minimercado.controller;

import org.springframework.web.bind.annotation.*;
import sena.codejava.minimercado.model.Venta;
import sena.codejava.minimercado.repository.VentaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin("*")
public class VentaController {

    private final VentaRepository repo;

    public VentaController(VentaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Venta> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return repo.save(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        repo.deleteById(id);
    }
}
