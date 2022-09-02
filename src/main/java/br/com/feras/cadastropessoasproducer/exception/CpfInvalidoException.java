package br.com.feras.cadastropessoasproducer.exception;

public class CpfInvalidoException extends InputValidationException {
  public CpfInvalidoException() {
    super("pessoa.cpf", "cpf não é válido");
  }
}
