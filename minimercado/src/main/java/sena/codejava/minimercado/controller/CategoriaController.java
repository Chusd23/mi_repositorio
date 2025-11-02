
package sena.codejava.minimercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sena.codejava.minimercado.model.Categoria;
import sena.codejava.minimercado.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repo;

    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Categoria agregar(@RequestBody Categoria c) {
        return repo.save(c);
    }

    @GetMapping("/{id}")
    public Categoria obtenerPorId(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        repo.deleteById(id);
    }
}