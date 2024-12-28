package com.luismiguel.forumOne.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luismiguel.forumOne.domain.perfil.Perfil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;
  public String gerarToken(Perfil perfil) {
    try {
      var algoritmo = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("API Forum.one")
          .withSubject(perfil.getLogin())
          .withExpiresAt(dataExpiracao())
          .sign(algoritmo);
    } catch (JWTCreationException exception){
      throw new RuntimeException("erro ao gerar token jwt", exception);
    }
  }

  public String getSubject(String tokenJWT) {
    try {
      var algoritmo = Algorithm.HMAC256(secret);
      return JWT.require(algoritmo)
          .withIssuer("API Forum.one")
          .build()
          .verify(tokenJWT)
          .getSubject();
    } catch (JWTVerificationException exception) {
      throw new RuntimeException("Token JWT inválido ou expirado!");
    }
  }

  private Instant dataExpiracao() { //-> vai definir o tempo de expiração do token
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}