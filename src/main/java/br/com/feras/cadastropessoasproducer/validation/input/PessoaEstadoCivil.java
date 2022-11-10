package br.com.feras.cadastropessoasproducer.validation.input;

public enum PessoaEstadoCivil {

  SOLTEIRO("650"),
  CASADO("651"),
  DIVORCIADO("652"),
  VIUVO("653"),
  SEPARADO_JUDICIALMENTE("654");

  private String valor;

  PessoaEstadoCivil(String valor) {
    this.valor = valor;
  }

  public static boolean isEstadoCivilValido(String valorEstadoC) {
    for (PessoaEstadoCivil estadoC : PessoaEstadoCivil.values()) {
      if (estadoC.valor.equalsIgnoreCase(valorEstadoC)) {
        return true;
      }
    }
    return false;
  }
}
