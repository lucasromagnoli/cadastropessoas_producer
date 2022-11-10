package br.com.feras.cadastropessoasproducer.domain.dto;

import lombok.Data;

@Data
public class PessoaDto {

  private String nome;
  private String cpf;
  private String dataNascimento;
  private String dataFalecimento;
  private String nacionalidade;
  private String estadoCivil;
  private String sexo;
  private String cidadeNascimento;
  private Cidade cidade;

  public void normalizarCampos() {
    this.normalizarNome();
    this.normalizarNacionalidade();
    this.normalizarSexo();
    this.normalizarCidade();
  }

  public void normalizarNome(){
    String nomeNormalizado = normalizarTexto(this.getNome());
    this.setNome(nomeNormalizado);
  }

  public void normalizarNacionalidade(){
    String nacionalidadeNormalizada = normalizarTexto(this.getNacionalidade());
    this.setNacionalidade(nacionalidadeNormalizada);
  }

  public void normalizarSexo(){
    String sexoNormalizado = normalizarTexto(this.getSexo().toUpperCase());
    this.setSexo(sexoNormalizado);
  }

  public void normalizarCidade(){
    String cidadeNormalizada = normalizarTexto(this.getCidadeNascimento());
    this.setCidadeNascimento(cidadeNormalizada);
  }

  private String normalizarTexto(String texto) {
    String textoNormalizado = texto.trim();
    textoNormalizado = textoNormalizado.replaceAll("\\s+", " ");
    return textoNormalizado;
  }

}

