package br.com.feras.cadastropessoasproducer.validation.business;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PessoaBusinessValidation {
  public void validar(PessoaDto pessoaDto) {

    LocalDate dataAtual = LocalDate.now();

    if(dataAtual.isBefore(pessoaDto.getDataNascimento())) {
      throw new InputValidationException("pessoa.dataNascimento", "Data Nascimento não pode ser maior do que a data atual");
    }

    Integer tamanhoNome = pessoaDto.getNome().trim().split(" ").length;

    if(tamanhoNome <= 1) {
      throw new InputValidationException("pessoa.nome", "É preciso informar um nome e um sobrenome");
    }

    // Cpf já existe no banco de dados?

  }
}
