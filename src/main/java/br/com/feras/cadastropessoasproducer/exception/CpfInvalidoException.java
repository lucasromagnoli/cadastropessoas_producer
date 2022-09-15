package br.com.feras.cadastropessoasproducer.exception;

public class CpfInvalidoException extends InputValidationException {
  public CpfInvalidoException() {
    super("pessoa.cpf", "CPF não é válido.");
  }
}
