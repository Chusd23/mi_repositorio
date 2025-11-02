package sena.codejava.minimercado.controller;

import org.springframework.web.bind.annotation.*;
import sena.codejava.minimercado.model.Pago;
import sena.codejava.minimercado.repository.PagoRepository;
import java.util.List;

@RestController
@RequestMapping("/api/pago")
@CrossOrigin("*")
public class PagoController {

    private final PagoRepository repo;

    public PagoController(PagoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pago> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Pago guardar(@RequestBody Pago pago) {
        return repo.save(pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        repo.deleteById(id);
    }
}

