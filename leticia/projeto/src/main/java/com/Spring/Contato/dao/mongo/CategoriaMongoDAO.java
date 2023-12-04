package com.Spring.Contato.dao.mongo;

import com.Spring.Contato.dao.CategoriaDAO;
import com.Spring.Contato.entity.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaMongoDAO extends CategoriaDAO, MongoRepository<Categoria, String> {

    @Query("{ 'numero' : ?0 }")
    List<Categoria> findByNumero(String numero);

    @Query("{ 'id' : ?0 }")
    Optional<Categoria> findById(int id);

    @Query("{ 'nome' : ?0 }")
    Optional<Categoria> findByNome(String categoriaAntiga);
}