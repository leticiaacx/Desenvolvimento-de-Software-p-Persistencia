package com.Spring.Contato.dao.jpa;

import com.Spring.Contato.dao.CategoriaDAO;
//import com.Spring.Contato.dao.CategoriaDAO;
import com.Spring.Contato.entity.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaJPADAO extends CategoriaDAO, JpaRepository<Categoria, String> {

    // Método usando consulta derivada de método
    List<Categoria> findByNumero(String numero);

    // Método usando consulta JPQL
    @Query("SELECT ca FROM Categoria ca WHERE ca.id = :id")
    Optional<Categoria> findById(int id);

    // Método usando consulta derivada de método
    Optional<Categoria> findByNome(String categoriaAntiga);
}
