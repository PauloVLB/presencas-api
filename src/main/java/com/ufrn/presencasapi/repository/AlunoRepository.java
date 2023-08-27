package com.ufrn.presencasapi.repository;

import com.ufrn.presencasapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
