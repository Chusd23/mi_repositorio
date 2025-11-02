package sena.codejava.minimercado.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sena.codejava.minimercado.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

