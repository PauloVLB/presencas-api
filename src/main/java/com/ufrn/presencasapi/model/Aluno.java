package com.ufrn.presencasapi.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "tb_aluno")
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "turma")
    private String turma;

    @ManyToMany(mappedBy = "alunos", fetch = FetchType.EAGER)
    Set<Monitoria> monitorias;
}
