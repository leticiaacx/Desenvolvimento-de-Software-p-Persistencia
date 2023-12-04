package com.Spring.Contato.dao.mongo;

import com.Spring.Contato.dao.CompromissoDAO;
import com.Spring.Contato.entity.Compromisso;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoMongoDAO extends CompromissoDAO, MongoRepository<Compromisso, String> {

    @Query("{ 'titulo' : ?0 }")
    Optional<Compromisso> findByTitulo(String titulo);

    @Query("{ 'data' : ?0 }")
    List<Compromisso> findByData(String data);

    @Query("{ 'compromissoId' : ?0 }")
    List<Compromisso> findByCompromissoId(int compromissoId);

    @Query("{ 'id' : ?0 }")
    Optional<Compromisso> findById(String id);
}