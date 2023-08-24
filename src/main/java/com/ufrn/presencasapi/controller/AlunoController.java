package com.ufrn.presencasapi.controller;

import com.ufrn.presencasapi.dto.AlunoDTO;
import com.ufrn.presencasapi.model.Aluno;
import com.ufrn.presencasapi.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoDTO alunoDto) {
        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);
        return new ResponseEntity<>(service.save(aluno), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findOneById(@PathVariable Long id) {
        Optional<Aluno> aluno = service.findById(id);
        return ResponseEntity.ok(aluno.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoDTO alunoDto) {
        Optional<Aluno> alunoOptional = service.findById(id);

        Aluno alunoToUpdate = alunoOptional.get();
        BeanUtils.copyProperties(alunoDto, alunoToUpdate);

        service.save(alunoToUpdate);

        return ResponseEntity.ok(alunoToUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
