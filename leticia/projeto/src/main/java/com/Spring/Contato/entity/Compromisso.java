package com.Spring.Contato.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@NamedQuery(name = "compromissoPorTitulo", query = "SELECT co FROM Compromisso co WHERE co.titulo ilike :titulo")

@Document(collection = "compromisso")
@Entity
@Data
@Table(name = "Compromisso")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String titulo;

    @NonNull
    private String data;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFim;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Categoria categoria;

    public List<Categoria> getCategorias() {
        return null;
    }
}
