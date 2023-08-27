package com.ufrn.presencasapi.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MonitoriaInputDTO {
    @NotBlank
    private String nomeMonitor;
    private LocalDate data;
    @NotBlank
    private String horario;
    private String sala;
}
