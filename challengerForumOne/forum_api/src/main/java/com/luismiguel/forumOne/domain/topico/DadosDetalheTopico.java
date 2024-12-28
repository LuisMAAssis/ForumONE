package com.luismiguel.forumOne.domain.topico;

import com.luismiguel.forumOne.domain.curso.Curso;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalheTopico(Long id, String titulo, String mensagem, String autor, Curso curso, Status status, List<String> respostas, LocalDateTime dataCriacao) {
  public DadosDetalheTopico(Topico topico) {
    this(topico.getId(),
        topico.getTitulo(),
        topico.getMensagem(),
        topico.getAutor(),
        topico.getCurso(),
        topico.getStatus(),
        topico.getRespostas(),
        topico.getDataCriacao());
  }
}