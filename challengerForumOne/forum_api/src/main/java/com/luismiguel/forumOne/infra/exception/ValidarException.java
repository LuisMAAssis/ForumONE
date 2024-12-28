package com.luismiguel.forumOne.infra.exception;

public class ValidarException extends RuntimeException{
  public ValidarException(String mensagem) {
    super(mensagem);
  }
}