package br.com.feras.cadastropessoasproducer.validation.input;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.CpfInvalidoException;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;
import software.amazon.awssdk.utils.StringUtils;

import static java.util.Objects.isNull;

public class ValidarPessoa {

  public static void validacao(PessoaDto pessoa){

    if (isCampoEmbranco(pessoa.getNome())){
      throw new InputValidationException("pessoa.nome", "Nome não pode ser vazio.");
    }

    if (isCampoEmbranco(pessoa.getCpf()) || ValidaCPF.isCPF(pessoa.getCpf()) == false) {
      throw new CpfInvalidoException();
    }

    if (isCampoEmbranco(pessoa.getDataNascimento())) {
      throw new InputValidationException("pessoa.getDataNascimento", "Data de nascimento não pode ser vazio");
    }

    if (!ValidaData.isFormatoDataValido(pessoa.getDataNascimento())) {
      throw new InputValidationException("pessoa.getDataNascimento", "Formato de data inválido.");
    }

    if (isCampoEmbranco(pessoa.getNacionalidade())){
      throw new InputValidationException("pessoa.getNacionalidade", "Nacionalidade não pode ser vazio");
    }

    if (isCampoEmbranco(pessoa.getEstadoCivil())){
      throw new InputValidationException("pessoa.getEstadoCivil", "Estado civil não pode ser vazio");
    }

    if (isCampoEmbranco(pessoa.getSexo())){
      throw new InputValidationException("pessoa.getSexo", "Sexo não pode ser vazio");
    }

    if (isCampoEmbranco(pessoa.getCidadeNascimento())){
      throw new InputValidationException("pessoa.getCidadeNascimento", "Cidade Nascimento não pode ser vazio");
    }

    if (pessoa.getTelefone() != null && (isCampoEmbranco(pessoa.getTelefone().getDdi()) ||
        isCampoEmbranco(pessoa.getTelefone().getDdd()) || isCampoEmbranco(pessoa.getTelefone().getNumero()))){
      throw new InputValidationException("pessoa.getTelefone", "Dados do telefone não podem ser vazios.");
    }

    if (pessoa.getEndereco() != null && isCampoEmbranco(pessoa.getEndereco().getLogradouro())){
      throw new InputValidationException("pessoa.getEndereco", "Logradouro é obrigatório.");
    }

    if (pessoa.getEndereco() != null && (pessoa.getEndereco().getCidade() == null ||
      isCampoEmbranco(pessoa.getEndereco().getCidade().getNomeCidade()) ||
      isCampoEmbranco(pessoa.getEndereco().getCidade().getNomeEstado()) ||
      isCampoEmbranco(pessoa.getEndereco().getCidade().getNomePais()))){
      throw new InputValidationException("pessoa.getEndereco", "Cidade/Estado/País não pode estar vazio.");
    }

    if (pessoa.getEndereco() != null && isCampoEmbranco(pessoa.getEndereco().getCep())){
      throw new InputValidationException("pessoa.getEndereco", "CEP é obrigatório.");
    }

  }

  private static boolean isCampoEmbranco(String campo){
    return campo == null || campo.isBlank();
  }
}

