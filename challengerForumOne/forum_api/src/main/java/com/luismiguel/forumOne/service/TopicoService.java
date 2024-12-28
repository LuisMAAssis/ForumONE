package com.luismiguel.forumOne.service;

import com.luismiguel.forumOne.domain.topico.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
  @Autowired
  private TopicoRepository repository;

  public TopicoService(TopicoRepository repository) {
    this.repository = repository;
  }

  public Topico criarTopico(DadosCriacaoTopico dados) {
    Topico topico = new Topico(dados);
    return repository.save(topico);
  }

  public List<DadosListagemTopico> listarTopicos() {
    return repository.findAll().stream()
        .map(DadosListagemTopico::new)
        .toList();
  }

  public DadosDetalheTopico detalharTopico(Long id) {
    Topico topico = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));
    return new DadosDetalheTopico(topico);
  }

  public Topico atualizarTopico(Long id, DadosAtualizacaoTopico dados) {
    Topico topico = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));
    topico.atualizacaoTopico(dados);
    return repository.save(topico);
  }

  public void excluirTopico(Long id) {
    if (!repository.existsById(id)) {
      throw new EntityNotFoundException("Tópico não encontrado");
    }
    repository.deleteById(id);
  }
}
