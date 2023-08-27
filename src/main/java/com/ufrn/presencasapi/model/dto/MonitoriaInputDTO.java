package com.ufrn.presencasapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MonitoriaInputDTO {
    @NotBlank
    private String nomeMonitor;
    private LocalDate data;
    @NotBlank
    private String horario;
    private String sala;
}
