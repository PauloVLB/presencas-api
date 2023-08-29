package com.ufrn.presencasapi.controller;

import com.ufrn.presencasapi.model.dto.MonitoriaInputDTO;
import com.ufrn.presencasapi.model.Monitoria;
import com.ufrn.presencasapi.service.MonitoriaService;
import com.ufrn.utils.exception.BadRequestException;
import com.ufrn.utils.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("monitoria")
public class MonitoriaController {
    private final MonitoriaService service;
    @PostMapping
    public ResponseEntity<Monitoria> save(@RequestBody @Valid MonitoriaInputDTO monitoriaDto) {
        Monitoria monitoria = new Monitoria();
        BeanUtils.copyProperties(monitoriaDto, monitoria);

        Monitoria monitoriaSave = service.save(monitoria);
        if(monitoriaSave == null) throw new BadRequestException();

        return ResponseEntity.ok(monitoriaSave);
    }
    @GetMapping
    public ResponseEntity<List<Monitoria>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Monitoria> findOneById(@PathVariable Long id) {
        Optional<Monitoria> monitoria = service.findById(id);

        if(monitoria.isEmpty()) throw new NotFoundException("Não foi possível encontrar a monitoria com id " + id + ".");

        return ResponseEntity.ok(monitoria.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Monitoria> update(@PathVariable Long id,
                                                     @RequestBody @Valid MonitoriaInputDTO monitoriaDto) {
        Optional<Monitoria> monitoriaOptional = service.findById(id);

        if(monitoriaOptional.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar a monitoria com id " + id + " para atualizar.");
        }

        Monitoria monitoriaToUpdate = monitoriaOptional.get();
        BeanUtils.copyProperties(monitoriaDto, monitoriaToUpdate);

        if(service.save(monitoriaToUpdate) == null) {
            throw new BadRequestException();
        }

        return ResponseEntity.ok(monitoriaToUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        Optional<Monitoria> monitoriaToDelete = service.findById(id);

        if(monitoriaToDelete.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar a monitoria com id " + id + " para remoção.");
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
