package com.ufrn.presencasapi.service;

import com.ufrn.presencasapi.model.Aluno;
import com.ufrn.presencasapi.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {
    final private AlunoRepository repository;
    public List<Aluno> findAll() { return repository.findAll(); }
    public Optional<Aluno> findById(Long id) { return repository.findById(id); }
    public Aluno save(Aluno aluno) { return repository.save(aluno); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
