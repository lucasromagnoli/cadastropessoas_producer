package br.com.feras.cadastropessoasproducer.controller;

import br.com.feras.cadastropessoasproducer.domain.message.MessageTemplate;
import br.com.feras.cadastropessoasproducer.domain.message.MessageType;
import br.com.feras.cadastropessoasproducer.service.PessoaService;
import br.com.feras.cadastropessoasproducer.validation.input.ValidarPessoa;
import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
  private final PessoaService pessoaService;
  public PessoaController(PessoaService pessoaService) {
    this.pessoaService = pessoaService;
  }

  @PostMapping
  public ResponseEntity<MessageTemplate> adicionar(@RequestBody PessoaDto pessoaDto){
    ValidarPessoa.validacao(pessoaDto);

    pessoaService.enviarPraFila(pessoaDto); // throw, vai pegar e jogar pra cima (o nosso exception handler)

    return MessageTemplate.builder()
      .type(MessageType.SUCCESS)
      .message("Solicitação de cadastro de pessoa encaminhada com sucesso.")
      .build()
      .toResponseEntity();
  }
}
