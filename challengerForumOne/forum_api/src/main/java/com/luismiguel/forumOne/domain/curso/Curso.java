package com.luismiguel.forumOne.domain.curso;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;

@Embeddable
@AllArgsConstructor
public class Curso {
  @Column(name = "nomeCurso")
  private String nomeCurso;

  @Enumerated(EnumType.STRING)
  private Categoria categoria;

  public Curso() {
  }

  public Curso(DadosCurso dados) {
    this.nomeCurso = dados.nomeCurso();
    this.categoria = dados.categoria();
  }

  public void atualizarInformacoes(DadosCurso dados) {
    if (dados.nomeCurso() != null) {
      this.nomeCurso = dados.nomeCurso();
    }
    if (dados.categoria() != null) {
      this.categoria = dados.categoria();
    }
  }
}