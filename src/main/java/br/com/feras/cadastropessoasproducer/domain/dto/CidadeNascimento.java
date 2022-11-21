package br.com.feras.cadastropessoasproducer.domain.dto;

public class CidadeNascimento {

  private String nomeCidade;
  private String nomeEstado;
  private String siglaEstado;
  private String nomePais;
  private String siglaPais;

  public CidadeNascimento(String nomeCidade, String nomeEstado, String siglaEstado, String nomePais, String siglaPais) {
    this.nomeCidade = nomeCidade;
    this.nomeEstado = nomeEstado;
    this.siglaEstado = siglaEstado;
    this.nomePais = nomePais;
    this.siglaPais = siglaPais;
  }

  public CidadeNascimento(){
  }

  public String getNomeCidade() {
    return nomeCidade;
  }

  public void setNomeCidade(String nomeCidade) {
    this.nomeCidade = nomeCidade;
  }

  public String getNomeEstado() {
    return nomeEstado;
  }

  public void setNomeEstado(String nomeEstado) {
    this.nomeEstado = nomeEstado;
  }

  public String getSiglaEstado() {
    return siglaEstado;
  }

  public void setSiglaEstado(String siglaEstado) {
    this.siglaEstado = siglaEstado;
  }

  public String getNomePais() {
    return nomePais;
  }

  public void setNomePais(String nomePais) {
    this.nomePais = nomePais;
  }

  public String getSiglaPais() {
    return siglaPais;
  }

  public void setSiglaPais(String siglaPais) {
    this.siglaPais = siglaPais;
  }

  @Override
  public String toString() {
    return "Cidade{" +
      "nomeCidade='" + nomeCidade + '\'' +
      ", nomeEstado='" + nomeEstado + '\'' +
      ", siglaEstado='" + siglaEstado + '\'' +
      ", nomePais='" + nomePais + '\'' +
      ", siglaPais='" + siglaPais + '\'' +
      '}';
  }
}
