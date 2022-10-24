package br.com.feras.cadastropessoasproducer.service;

import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import br.com.feras.cadastropessoasproducer.exception.InternalServerException;
import br.com.feras.cadastropessoasproducer.validation.business.PessoaBusinessValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

  private final SqsAsyncClient sqsAsyncClient;
  private final String queueUrl;
  private final ObjectMapper objectMapper;
  private final PessoaBusinessValidation pessoaBusinessValidation;

  public void enviarPraFila(PessoaDto pessoaDto) {
    pessoaBusinessValidation.validar(pessoaDto);

    try {
      sqsAsyncClient.sendMessage(SendMessageRequest.builder()
        .queueUrl(queueUrl)
        .messageBody(objectMapper.writeValueAsString(objectMapper))
        .build())
        .thenAccept(sendMessageResponse -> {
          log.info("Mensagem enviada com sucesso! messageId: [{}]", sendMessageResponse.messageId());
        });

    } catch (JsonProcessingException e) {
      throw new InternalServerException("Não foi possível construir o json do body da mensagem sqs.", e);
    }
  }
}
