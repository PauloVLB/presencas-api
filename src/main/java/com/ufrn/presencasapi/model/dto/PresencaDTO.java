package com.ufrn.presencasapi.model.dto;

import jakarta.validation.constraints.NotNull;

public record PresencaDTO(@NotNull Long monitoriaId, @NotNull Long alunoId) {
}
