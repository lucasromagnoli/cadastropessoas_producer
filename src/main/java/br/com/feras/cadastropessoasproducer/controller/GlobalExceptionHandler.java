package br.com.feras.cadastropessoasproducer.controller;

import br.com.feras.cadastropessoasproducer.domain.message.MessageError;
import br.com.feras.cadastropessoasproducer.domain.message.MessageTemplate;
import br.com.feras.cadastropessoasproducer.domain.message.MessageType;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;
import br.com.feras.cadastropessoasproducer.exception.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = InputValidationException.class)
  public ResponseEntity<MessageTemplate> inputValidationHandler(InputValidationException inputValidationException) {
    log.warn("Requisição não passou pela validação de entradas.");

    return MessageTemplate.builder()
      .type(MessageType.INPUT_VALIDATION)
      .message(inputValidationException.getMessage())
      .payload(MessageError.builder()
        .code(inputValidationException.getErrorCode())
        .detail(inputValidationException.getDetailMessage())
        .build())
      .build()
      .toResponseEntity();
  }

  @ExceptionHandler(value = InternalServerException.class)
  public ResponseEntity<MessageTemplate> internalServerExceptionHandler(InternalServerException internalServerException) {
    log.error("Aconteceu algum erro inesperado na aplicação.", internalServerException);

    return MessageTemplate.builder()
      .type(MessageType.ERROR)
      .message(internalServerException.getMessage())
      .build()
      .toResponseEntity();
  }
}
