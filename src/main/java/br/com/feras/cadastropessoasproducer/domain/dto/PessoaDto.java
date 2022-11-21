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
  private CidadeNascimento cidade;
  private Email email;
  private Telefone telefone;
  private Endereco endereco;

  public void normalizarCampos() {
    this.normalizarNome();
    this.normalizarNacionalidade();
    this.normalizarSexo();
    this.normalizarCidade();
    this.normalizarEmail();
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

  public void normalizarEmail(){
    if(this.getEmail() == null || this.getEmail().getValorEmail() == null) {
      return;
    }
    String emailNormalizado = normalizarTexto(this.getEmail().getValorEmail());
    this.getEmail().setValorEmail(emailNormalizado);
  }

  private String normalizarTexto(String texto) {
    String textoNormalizado = texto.trim();
    textoNormalizado = textoNormalizado.replaceAll("\\s+", " ");
    return textoNormalizado;
  }

}

