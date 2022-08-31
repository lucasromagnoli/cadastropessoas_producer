package br.com.feras.cadastropessoasproducer.exception;

import lombok.Getter;

@Getter
public class InputValidationException extends RuntimeException {
  private final String errorCode;
  private final String detailMessage;

  public InputValidationException(String errorCode, String detailMessage) {
    super("Validação de entradas, verifique os detalhes do erro e seu respectivo código.");
    this.errorCode = errorCode;
    this.detailMessage = detailMessage;
  }
}
