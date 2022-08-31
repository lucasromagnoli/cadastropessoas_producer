package br.com.feras.cadastropessoasproducer.configuration.validation;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;

public class ValidarPessoa {

  public static String validacao(PessoaDto pessoa){
    if (pessoa.getNome() == null || pessoa.getNome().isBlank()){
      return "Nome não pode ser vazio.";
    }

    if (pessoa.getCpf() == null || pessoa.getCpf().isBlank()){
      return "CPF não pode ser vazio.";
    }

    if (pessoa.getDataNascimento() == null){
      return "Data de nascimento não pode ser vazio.";
    }

    return null;
  }
}
