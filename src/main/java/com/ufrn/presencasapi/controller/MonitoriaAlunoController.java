package com.ufrn.presencasapi.controller;

import com.ufrn.presencasapi.model.Aluno;
import com.ufrn.presencasapi.model.Monitoria;
import com.ufrn.presencasapi.model.dto.PresencaDTO;
import com.ufrn.presencasapi.service.AlunoService;
import com.ufrn.presencasapi.service.MonitoriaService;
import com.ufrn.utils.exception.BadRequestException;
import com.ufrn.utils.exception.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("presencas")
public class MonitoriaAlunoController {
    private final MonitoriaService monitoriaService;
    private final AlunoService alunoService;
    @PostMapping
    public ResponseEntity<Monitoria> criarPresenca(@RequestBody @Valid PresencaDTO presencaDTO) {
        Long monitoriaId = presencaDTO.monitoriaId();
        Long alunoId = presencaDTO.alunoId();

        Optional<Monitoria> monitoriaOptional = monitoriaService.findById(monitoriaId);

        if(monitoriaOptional.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar a monitoria de id " + monitoriaId + ".");
        }

        Optional<Aluno> alunoOptional = alunoService.findById(alunoId);

        if(alunoOptional.isEmpty()) {
            throw new NotFoundException("Não foi possível encontrar o aluno de id " + alunoId + ".");
        }

        Monitoria monitoria = monitoriaOptional.get();
        Aluno aluno = alunoOptional.get();

        monitoria.getAlunos().add(aluno);

        Monitoria monitoriaSave = monitoriaService.save(monitoria);

        if(monitoriaSave == null) throw new BadRequestException();

        return ResponseEntity.ok(monitoriaSave);
    }

}
