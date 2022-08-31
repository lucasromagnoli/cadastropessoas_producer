package br.com.feras.cadastropessoasproducer.domain.dto;

import antlr.StringUtils;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PessoaDto {

  private String nome;
  private String cpf;
  private LocalDate dataNascimento;

}
