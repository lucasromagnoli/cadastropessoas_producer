package br.com.feras.cadastropessoasproducer.domain.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class MessageError implements Serializable {
  @JsonProperty("codigo_erro")
  private String code;

  @JsonProperty("detalhe_erro")
  private String detail;
}
