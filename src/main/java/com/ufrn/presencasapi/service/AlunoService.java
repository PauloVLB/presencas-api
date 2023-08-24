package com.ufrn.presencasapi.service;

import com.ufrn.presencasapi.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private JpaRepository<Aluno, Long> repository;

    public List<Aluno> findAll() { return repository.findAll(); }
    public Optional<Aluno> findById(Long id) { return repository.findById(id); }
    public Aluno save(Aluno aluno) { return repository.save(aluno); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
