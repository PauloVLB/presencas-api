package com.ufrn.presencasapi.dto;

import jakarta.validation.constraints.NotBlank;

public record AlunoDTO(@NotBlank String nome) {
}
