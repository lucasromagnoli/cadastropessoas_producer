package br.com.feras.cadastropessoasproducer.validation.input;

import br.com.feras.cadastropessoasproducer.domain.dto.CidadeNascimento;
import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;

public enum PessoaCidadeNascimento {

  SAO_PAULO("São Paulo", "São Paulo", "SP", "Brasil", "BR"),
  GOIANIA("Goiânia", "Goiás", "GO", "Brasil", "BR"),
  NOVA_IORQUE("Nova Iorque", "Nova Iorque", "NI", "Estados Unidos", "USA");

  private String nomeCidade;
  private String nomeEstado;
  private String siglaEstado;
  private String nomePais;
  private String siglaPais;

  PessoaCidadeNascimento(String nomeCidade, String nomeEstado, String siglaEstado, String nomePais, String siglaPais) {
    this.nomeCidade = nomeCidade;
    this.nomeEstado = nomeEstado;
    this.siglaEstado = siglaEstado;
    this.nomePais = nomePais;
    this.siglaPais = siglaPais;
  }

  public static boolean isCidadeValidaRetornaObjeto(PessoaDto pessoa) {
    for (PessoaCidadeNascimento cidadeEnum : PessoaCidadeNascimento.values()) {
      if (cidadeEnum.nomeCidade.equalsIgnoreCase(pessoa.getCidadeNascimento())) {
        CidadeNascimento cidade = new CidadeNascimento(cidadeEnum.nomeCidade, cidadeEnum.nomeEstado, cidadeEnum.siglaEstado, cidadeEnum.nomePais, cidadeEnum.siglaPais);
        pessoa.setCidade(cidade);
        return true;
      }
    }
    return false;
  }
}
