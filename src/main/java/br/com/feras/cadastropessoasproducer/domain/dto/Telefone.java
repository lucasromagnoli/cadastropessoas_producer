package br.com.feras.cadastropessoasproducer.domain.dto;

import software.amazon.awssdk.utils.StringUtils;

public class Telefone {

  private String ddi;
  private String ddd;
  private String numero;

  public static boolean telefoneValidator(Telefone telefone){
    if (telefone == null){
      return true;
    }
    String telefoneCompleto = telefone.ddi + telefone.ddd + telefone.numero ;
    return telefoneCompleto.matches("\\d+");
  }

  public String getDdi() {
    return ddi;
  }

  public String getDdd() {
    return ddd;
  }

  public String getNumero() {
    return numero;
  }
}
