package com.Spring.Contato.dao.jpa;

import com.Spring.Contato.dao.CompromissoDAO;
//import com.Spring.Contato.dao.CompromissoDAO;
import com.Spring.Contato.entity.Compromisso;
import com.Spring.Contato.entity.Contato;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoJPADAO extends CompromissoDAO, JpaRepository<Compromisso, String> {

    Optional<Compromisso> findByTitulo(String titulo);

    // Método usando consulta derivada de método
    List<Compromisso> findByData(String data);


    // Native Query - todas as vendas relacionadas a carros com preço acima de um valor específico
    @Query(value = "SELECT * FROM Compromisso WHERE compromissoId = :compromissoId", nativeQuery = true)
    List<Compromisso> findByCompromissoId(@Param("compromissoId") int compromissoId);
    

    Optional<Compromisso> findById(String id);
}
