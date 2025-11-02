package sena.codejava.minimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.codejava.minimercado.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

