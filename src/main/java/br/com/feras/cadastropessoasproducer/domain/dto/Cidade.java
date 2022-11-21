package br.com.feras.cadastropessoasproducer.domain.dto;

public class Cidade {

  private String nomeCidade;
  private String nomeEstado;
  private String nomePais;

  public Cidade() {
  }

  public Cidade(String nomeCidade, String nomeEstado, String nomePais) {
    this.nomeCidade = nomeCidade;
    this.nomeEstado = nomeEstado;
    this.nomePais = nomePais;
  }

  public String getNomeCidade() {
    return nomeCidade;
  }

  public String getNomeEstado() {
    return nomeEstado;
  }

  public String getNomePais() {
    return nomePais;
  }

}
