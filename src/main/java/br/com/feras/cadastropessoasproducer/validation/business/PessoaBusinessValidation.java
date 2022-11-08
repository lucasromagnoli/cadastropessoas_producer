package br.com.feras.cadastropessoasproducer.validation.business;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;
import br.com.feras.cadastropessoasproducer.validation.input.ValidaData;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PessoaBusinessValidation {
  public void validar(PessoaDto pessoaDto) {
    pessoaDto.normalizarNome();

    if(!pessoaDto.getNome().matches("[A-Za-z ]+")) {
      throw new InputValidationException("pessoa.nome", "Apenas caracteres alfabéticos são permitidos.");
    }

    if(pessoaDto.getNome().length() < 2 || pessoaDto.getNome().length() > 255){
      throw new InputValidationException("pessoa.nome", "Nome deve conter no mínimo 2 caracteres e no máximo 255");
    }

    if(!ValidaData.isDataValida(pessoaDto.getDataNascimento())) {
      throw new InputValidationException("pessoa.dataNascimento", "Idade deve ser maior que 18 anos.");
    }

  }

}
