package br.com.feras.cadastropessoasproducer.service;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.validation.business.PessoaBusinessValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Service
@RequiredArgsConstructor
public class PessoaService {
  private final SqsAsyncClient sqsAsyncClient;
  private final PessoaBusinessValidation pessoaBusinessValidation;
  public void enviarPraFila(PessoaDto pessoaDto) {
    pessoaBusinessValidation.validar(pessoaDto);


  }
}
