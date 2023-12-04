package com.Spring.Contato.dao.mongo;

import com.Spring.Contato.dao.ContatoDAO;
import com.Spring.Contato.entity.Contato;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoMongoDAO extends ContatoDAO, MongoRepository<Contato, String> {

    @Query("{ 'cpf' : ?0 }")
    Contato findByCpf(String cpf);

    @Query("{ 'nome' : ?0 }")
    List<Contato> findByNome(String nome);

    @Query("{ 'numero' : ?0 }")
    Contato findByNumero(String numero);

    void delete(Contato contato);
}