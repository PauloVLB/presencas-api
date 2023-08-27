package com.ufrn.presencasapi.controller;

import com.ufrn.presencasapi.dto.AlunoDTO;
import com.ufrn.presencasapi.model.Aluno;
import com.ufrn.presencasapi.service.AlunoService;
import com.ufrn.utils.exception.BadRequestException;
import com.ufrn.utils.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
@RequiredArgsConstructor
public class AlunoController {
    @Autowired
    private final AlunoService service;

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoDTO alunoDto) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDto, aluno);

        Aluno alunoSave = service.save(aluno);
        if(alunoSave == null) throw new BadRequestException();

        return ResponseEntity.ok(alunoSave);
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findOneById(@PathVariable Long id) {
        Optional<Aluno> aluno = service.findById(id);

        if(aluno.isEmpty()) throw new NotFoundException("Não foi possível encontrar o aluno com id " + id + ".");

        return ResponseEntity.ok(aluno.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody @Valid AlunoDTO alunoDto) {
        Optional<Aluno> alunoOptional = service.findById(id);

        if(alunoOptional.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar o aluno com id " + id + " para atualizar.");
        }

        Aluno alunoToUpdate = alunoOptional.get();
        BeanUtils.copyProperties(alunoDto, alunoToUpdate);

        if(service.save(alunoToUpdate) == null) {
            throw new BadRequestException();
        }

        return ResponseEntity.ok(alunoToUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> delete(@PathVariable Long id) {
        Optional<Aluno> alunoToDelete = service.findById(id);

        if(alunoToDelete.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar o aluno com id " + id + " para remoção.");
        }

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
