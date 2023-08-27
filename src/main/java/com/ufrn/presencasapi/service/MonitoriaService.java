package com.ufrn.presencasapi.service;

import com.ufrn.presencasapi.model.Monitoria;
import com.ufrn.presencasapi.repository.MonitoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitoriaService {
    final private MonitoriaRepository repository;
    public List<Monitoria> findAll() { return repository.findAll(); }
    public Optional<Monitoria> findById(Long id) { return repository.findById(id); }
    public Monitoria save(Monitoria monitoria) { return repository.save(monitoria); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
