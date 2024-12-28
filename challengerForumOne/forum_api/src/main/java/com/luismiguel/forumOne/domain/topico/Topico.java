package com.luismiguel.forumOne.domain.topico;

import com.luismiguel.forumOne.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String mensagem;
  private String autor;

  @Embedded
  private Curso curso;

  @Enumerated(EnumType.STRING)
  private Status status;

  private List<String> respostas = new ArrayList<>();

  private LocalDateTime dataCriacao;

  public Topico() {
  }

  public Topico(DadosCriacaoTopico dados) {
    this.titulo = dados.titulo();
    this.mensagem = dados.mensagem();
    this.autor = dados.autor();
    this.curso = new Curso(dados.curso());
    this.status = Status.NAO_RESPONDIDO;
    this.respostas = dados.respostas();
    this.dataCriacao = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<String> getRespostas() {
    return respostas;
  }

  public void setRespostas(List<String> respostas) {
    this.respostas = respostas;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public void atualizacaoTopico(DadosAtualizacaoTopico dados) {
    if (dados.titulo() != null) {
      this.titulo = dados.titulo();
    }
    if (dados.mensagem() != null) {
      this.mensagem = dados.mensagem();
    }
    if (dados.curso() != null) {
      this.curso.atualizarInformacoes(dados.curso());
    }
  }

  public void atualizarStatus() {
    if (!respostas.isEmpty()) {
      this.status = Status.RESPONDIDO;
    }
  }
}
