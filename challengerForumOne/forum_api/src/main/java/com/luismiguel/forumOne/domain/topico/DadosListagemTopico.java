package com.luismiguel.forumOne.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, String autor, Status status, LocalDateTime dataCriacao) {
  public DadosListagemTopico(Topico topico) {
    this(topico.getId(),
        topico.getTitulo(),
        topico.getMensagem(),
        topico.getAutor(),
        topico.getStatus(),
        topico.getDataCriacao());
  }
}
