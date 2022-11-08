package br.com.feras.cadastropessoasproducer.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PessoaDto {

  private String nome;
  private String cpf;
  private String dataNascimento;

  public void normalizarNome(){
    String nomeNormalizado = this.getNome().trim();
    nomeNormalizado = nomeNormalizado.replaceAll("\\s+", " ");

    this.setNome(nomeNormalizado);
  }

}

