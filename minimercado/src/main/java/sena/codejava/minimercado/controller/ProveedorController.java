package sena.codejava.minimercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sena.codejava.minimercado.model.Proveedor;
import sena.codejava.minimercado.repository.ProveedorRepository;
import java.util.List;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(@PathVariable int id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Proveedor updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        Proveedor existente = proveedorRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(proveedor.getNombre());
            existente.setTelefono(proveedor.getTelefono());
            existente.setEmail(proveedor.getEmail());
            return proveedorRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable int id) {
        proveedorRepository.deleteById(id);
    }
}
