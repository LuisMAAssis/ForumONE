package com.luismiguel.forumOne.controller;

import com.luismiguel.forumOne.domain.topico.*;
import com.luismiguel.forumOne.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

  @Autowired
  private TopicoService topicoService;

  @Autowired
  public TopicoController(TopicoService topicoService) {
    this.topicoService = topicoService;
  }

  @PostMapping
  @Transactional
  public ResponseEntity criar(@RequestBody @Validated DadosCriacaoTopico dados) {
    Topico topicoCriado = topicoService.criarTopico(dados);
    return ResponseEntity.status(201).body(topicoCriado);
  }

  @GetMapping
  public ResponseEntity<List<DadosListagemTopico>> listar() {
    List<DadosListagemTopico> topicos = topicoService.listarTopicos();
    return ResponseEntity.ok(topicos);
  }

  @GetMapping("/{id}")
  public ResponseEntity detalhar(@PathVariable Long id) {
    DadosDetalheTopico detalhe = topicoService.detalharTopico(id);
    return ResponseEntity.ok(detalhe);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity atualizar(
      @PathVariable Long id,
      @RequestBody @Validated DadosAtualizacaoTopico dados) {
    var atualiza = topicoService.atualizarTopico(id, dados);
    return ResponseEntity.ok(new DadosDetalheTopico(atualiza));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id) {
    topicoService.excluirTopico(id);
    return ResponseEntity.noContent().build();
  }
}