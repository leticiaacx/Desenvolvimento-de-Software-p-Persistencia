package com.Spring.Contato.dao;

import java.util.List;
import java.util.Optional;

import com.Spring.Contato.entity.Compromisso;

public interface CompromissoDAO {

    public void save(Compromisso cl);

    public Optional<Compromisso> findByTitulo(String titulo);
    
    //public List<Compromisso> findCompromissoPorData(String data);

    //public List<Compromisso> findByCompromissoId(String id);
    
    public Optional<Compromisso> findById(String id);

    public List<Compromisso> findAll();

    public void deleteByTitulo(String titulo);

}