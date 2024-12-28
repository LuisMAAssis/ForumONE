package com.luismiguel.forumOne.domain.topico;

import com.luismiguel.forumOne.domain.curso.DadosCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCriacaoTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    @NotBlank
    String autor,
    @NotNull
    DadosCurso curso,
    List<String> respostas,
    LocalDateTime dataCriacao) {
}