package sena.codejava.minimercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.codejava.minimercado.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
}

