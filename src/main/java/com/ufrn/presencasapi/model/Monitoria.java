package com.ufrn.presencasapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_monitoria")
public class Monitoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_monitor")
    private String nomeMonitor;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private String horario;

    @Column(name = "sala")
    private String sala;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "monitoria_aluno",
               joinColumns = @JoinColumn(name = "monitoria_id"),
               inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    Set<Aluno> alunos = new HashSet<>();

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removeAluno(Long alunoId) {
        Aluno alunoRemove = 
                this.alunos.stream()
                           .filter(aluno -> aluno.getId() == alunoId)
                           .findFirst()
                           .orElse(null);
        if(alunoRemove != null) {
            this.alunos.remove(alunoRemove);
            alunoRemove.getMonitorias().remove(this);
        }
    }
}