package com.Spring.Contato.dao;

import java.util.List;
import java.util.Optional;

import com.Spring.Contato.entity.Contato;;

public interface ContatoDAO {

    public void save(Contato cl);

    public void delete(Contato co);

    public Optional<Contato> findById(String id);

    public List<Contato> findAll();

    public Contato findByCpf(String cpf);

    public Contato findByNumero(String numb);

    public List<Contato> findByNome(String str);
}
