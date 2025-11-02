package sena.codejava.minimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.codejava.minimercado.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
}

