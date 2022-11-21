package br.com.feras.cadastropessoasproducer.validation.business;

import br.com.feras.cadastropessoasproducer.domain.dto.Email;
import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.domain.dto.Telefone;
import br.com.feras.cadastropessoasproducer.exception.InputValidationException;
import br.com.feras.cadastropessoasproducer.validation.input.*;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.utils.StringUtils;

@Component
public class PessoaBusinessValidation {
  public void validar(PessoaDto pessoaDto) {
    pessoaDto.normalizarCampos();

    if(!pessoaDto.getNome().matches("[A-Za-z ]+")) {
      throw new InputValidationException("pessoa.nome", "Apenas caracteres alfabéticos são permitidos.");
    }

    if(pessoaDto.getNome().length() < 2 || pessoaDto.getNome().length() > 255){
      throw new InputValidationException("pessoa.nome", "Nome deve conter no mínimo 2 caracteres e no máximo 255.");
    }

    if(!ValidaData.isDataNascimentoValida(pessoaDto.getDataNascimento())){
      throw new InputValidationException("pessoa.dataNascimento", "Data de nascimento não pode ser maior do que a data atual.");
    }

    if(!ValidaData.isMaiorDe18(pessoaDto.getDataNascimento())) {
      throw new InputValidationException("pessoa.dataNascimento", "Idade deve ser maior que 18 anos.");
    }

    if(StringUtils.isNotBlank(pessoaDto.getDataFalecimento()) && !ValidaData.isDataFalecimentoValida(pessoaDto.getDataNascimento(), pessoaDto.getDataFalecimento())) {
      throw new InputValidationException("pessoa.dataNascimento,pessoa.dataFalecimento", "Data de falecimento inválida.");
    }

    if (!PessoaNacionalidade.isNacionalidadeValida(pessoaDto.getNacionalidade())){
      throw new InputValidationException("pessoa.nacionalidade", "Nacionalidade inválida.");
    }

    if(!pessoaDto.getEstadoCivil().matches("\\d+")) {
      throw new InputValidationException("pessoa.estadoCivil", "Apenas caracteres numéricos são permitidos.");
    }

    if (!PessoaEstadoCivil.isEstadoCivilValido(pessoaDto.getEstadoCivil())){
      throw new InputValidationException("pessoa.estadoCivil", "Estado civíl inválido.");
    }

    if ( !"F".equals(pessoaDto.getSexo()) && !"M".equals(pessoaDto.getSexo())){
      throw new InputValidationException("pessoa.estadoCivil", "Sexo inválido.");
    }

    if (!PessoaCidadeNascimento.isCidadeValidaRetornaObjeto(pessoaDto)){
      throw new InputValidationException("pessoa.cidadeNascimento", "Cidade inválida.");
    }

    if (pessoaDto.getEmail() != null && !Email.emailValidator(pessoaDto.getEmail().getValorEmail())){
      throw new InputValidationException("pessoa.email", "Email inválido.");
    }

    if (!Telefone.telefoneValidator(pessoaDto.getTelefone())){
      throw new InputValidationException("pessoa.telefone", "Telefone permite apenas caracteres numéricos.");
    }

    if (pessoaDto.getEndereco() != null && (pessoaDto.getEndereco().getLogradouro().length() < 3 || pessoaDto.getEndereco().getLogradouro().length() > 55)){
      throw new InputValidationException("pessoa.endereco", "Logradouro deve conter no mínimo 3 e no máximo 55 caracteres.");
    }

    if (pessoaDto.getEndereco() != null && pessoaDto.getEndereco().getNumero() != null && (!pessoaDto.getEndereco().getNumero().matches("\\d+"))){
      throw new InputValidationException("pessoa.endereco", "Número deve conter apenas caracteres numéricos.");
    }

    if (pessoaDto.getEndereco() != null && (!pessoaDto.getEndereco().getCep().matches("\\d+") || pessoaDto.getEndereco().getCep().length() != 8)){
      throw new InputValidationException("pessoa.endereco", "CEP deve conter 8 caracteres, todos numéricos.");
    }

    if (pessoaDto.getEndereco() != null && pessoaDto.getEndereco().getComplemento() != null && (pessoaDto.getEndereco().getComplemento().length() > 100)){
      throw new InputValidationException("pessoa.endereco", "Complemento deve conter no máximo 100 caracteres.");
    }
  }

}
