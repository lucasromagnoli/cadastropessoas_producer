package br.com.feras.cadastropessoasproducer.domain.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MessageType {
  SUCCESS(HttpStatus.OK),
  INPUT_VALIDATION(HttpStatus.BAD_REQUEST),
  ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

  private final HttpStatus httpStatus;
}
