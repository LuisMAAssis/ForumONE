package com.luismiguel.forumOne.controller;

import com.luismiguel.forumOne.domain.perfil.DadosAutenticacao;
import com.luismiguel.forumOne.domain.perfil.Perfil;
import com.luismiguel.forumOne.infra.security.DadosTokenJWT;
import com.luismiguel.forumOne.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticacaoController {
  @Autowired
  private AuthenticationManager manager;
  @Autowired
  private TokenService tokenService;
  @PostMapping
  public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
    var AuthenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
    var authentication = manager.authenticate(AuthenticationToken);
    var tokenJWT = tokenService.gerarToken((Perfil) authentication.getPrincipal());

    return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
  }
}
