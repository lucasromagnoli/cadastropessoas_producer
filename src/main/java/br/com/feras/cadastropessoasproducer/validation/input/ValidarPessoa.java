package br.com.feras.cadastropessoasproducer.validation.input;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.CpfInvalidoException;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;

import static java.util.Objects.isNull;

public class ValidarPessoa {

  public static void validacao(PessoaDto pessoa){
    if (pessoa.getNome() == null || pessoa.getNome().isBlank()){
      throw new InputValidationException("pessoa.nome", "Nome não pode ser vazio.");
    }

    if (isNull(pessoa.getCpf())|| pessoa.getCpf().isBlank() || ValidaCPF.isCPF(pessoa.getCpf()) == false) {
      throw new CpfInvalidoException();
    }

    if (pessoa.getDataNascimento() == null) {
      throw new InputValidationException("pessoa.getDataNascimento", "Data de nascimento não pode ser vazio");
    }

    if (!ValidaData.isFormatoDataValido(pessoa.getDataNascimento())) {
      throw new InputValidationException("pessoa.getDataNascimento", "Formato de data inválido.");
    }
  }
}

