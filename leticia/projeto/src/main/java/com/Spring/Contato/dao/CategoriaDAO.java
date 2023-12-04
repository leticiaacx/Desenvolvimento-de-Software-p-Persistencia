package com.Spring.Contato.dao;

import com.Spring.Contato.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {

    public void save(Categoria cl);

    public List<Categoria> findByNumero(String nome);

    //public List<Categoria> findByCategoriaId(String id);

    public Optional<Categoria> findById(String id);

    public Optional<Categoria> findByNome(String categoriaAntiga);

    public List<Categoria> findAll();

    void deleteByNome(String nome);
}
