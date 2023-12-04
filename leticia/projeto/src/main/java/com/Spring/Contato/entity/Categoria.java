package com.Spring.Contato.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;
import lombok.*;

@Document(collection = "categoria")
@Entity
@Data
@Table(name = "Categoria")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;  // Adicionando o campo descricao à classe Categoria

    private String numero;

    // Getters e Setters para descricao, conforme necessário
}
