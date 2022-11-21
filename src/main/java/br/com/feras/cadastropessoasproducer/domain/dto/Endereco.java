package br.com.feras.cadastropessoasproducer.domain.dto;

public class Endereco {

  private String logradouro;
  private Cidade cidade;
  private String numero;
  private String cep;
  private String complemento;

  public String getLogradouro() {
    return logradouro;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public String getNumero() {
    return numero;
  }

  public String getCep() {
    return cep;
  }

  public String getComplemento() {
    return complemento;
  }
}
