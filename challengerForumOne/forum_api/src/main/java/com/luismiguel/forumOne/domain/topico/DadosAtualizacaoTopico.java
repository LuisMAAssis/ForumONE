package com.luismiguel.forumOne.domain.topico;

import com.luismiguel.forumOne.domain.curso.DadosCurso;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
    @NotNull
    Long id,
    String titulo,
    String mensagem,
    DadosCurso curso) {

}