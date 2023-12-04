package com.Spring.Contato.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@NamedQuery(name = "contatoPorCpf", query = "SELECT c FROM Contato c WHERE c.cpf ilike :cpf")

@Document(collection = "contato")
@Data
@Entity
@Table(name = "Contato")
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String cpf; // Mudado para Long

    @Column(nullable = false)
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(nullable = false)
    private String numero;

    @Column(name = "email")
    private String email;

    @Column(name = "aniversario")
    private String aniversario;

    @ManyToOne
    private Categoria categoria;

    @Override
    public String toString() {
        return "Contato [ cpf=" + cpf + ", nome=" + nome + ", sobrenome=" + sobrenome + ", numero=" + numero + ", email=" + email + ", aniversario=" + aniversario + ", categoria=" + categoria + " ]";
    }

    public List<Categoria> getCategorias() {
        return null;
    }
}
