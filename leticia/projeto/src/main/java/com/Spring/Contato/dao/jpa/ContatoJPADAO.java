package com.Spring.Contato.dao.jpa;

import java.util.List;
import java.util.Optional;

import com.Spring.Contato.dao.ContatoDAO;
//import com.Spring.Contato.dao.ContatoDAO;
import com.Spring.Contato.entity.Contato;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ContatoJPADAO extends ContatoDAO, JpaRepository<Contato, String> {

    Contato findByCpf(String cpf);

    // Método usando consulta derivada de método
    List<Contato> findByNome(String nome);

    // Método usando consulta nativa
    @Query(value = "SELECT * FROM Contato WHERE numero = :numero", nativeQuery = true)
    Contato findByNumero(@Param("numero") String numero);

    void delete(Contato contato);
}
