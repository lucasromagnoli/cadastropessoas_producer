package br.com.feras.cadastropessoasproducer.validation.business;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import org.springframework.stereotype.Component;

@Component
public class PessoaBusinessValidation {
  public void validar(PessoaDto pessoaDto) {
    // Data de nascimento é maior ou igual a hoje? pq na nossa aplicação não aceitamos pessoas que nasceram no futuro.
    // Cpf já existe no banco de dados?

    // throw na exception falando que ele n passou na validacao
  }
}
