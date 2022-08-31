package br.com.feras.cadastropessoasproducer.domain.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Getter
@Builder
public class MessageTemplate implements Serializable {
  @JsonProperty("tipo")
  private MessageType type;

  @JsonProperty("message")
  private String message;

  @JsonProperty("payload")
  private Serializable payload;

  public ResponseEntity<MessageTemplate> toResponseEntity() {
    return ResponseEntity.status(this.type.getHttpStatus()).body(this);
  }
}
