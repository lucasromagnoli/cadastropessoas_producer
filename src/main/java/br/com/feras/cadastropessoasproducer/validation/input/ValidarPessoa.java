package br.com.feras.cadastropessoasproducer.validation.input;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.CpfInvalidoException;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;

import java.util.Objects;

import static java.util.Objects.isNull;

public class ValidarPessoa {

  public static void validacao(PessoaDto pessoa){
    if (pessoa.getNome() == null || pessoa.getNome().isBlank()){
      throw new InputValidationException("pessoa.nome", "Nome não pode ser vazio.");
    }

    if (isNull(pessoa.getCpf())) {
      throw new CpfInvalidoException();
    }

    if (pessoa.getCpf().length() != 11) {
      throw new InputValidationException("pessoa.cpf", "Cpf precisa ter exatamente 11 caracteres");
    }

    if (pessoa.getCpf() == null || pessoa.getCpf().isBlank()) {
      throw new InputValidationException("pessoa.cpf", "Cpf não pode ser vazio");
    }

  }
}
