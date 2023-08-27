package com.ufrn.presencasapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoDTO(@NotBlank String nome, @NotNull String turma) {
}
