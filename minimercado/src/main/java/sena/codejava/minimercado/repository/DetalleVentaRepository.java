package sena.codejava.minimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.codejava.minimercado.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}
