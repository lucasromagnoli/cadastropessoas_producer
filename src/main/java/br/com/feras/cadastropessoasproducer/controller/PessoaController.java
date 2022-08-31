package br.com.feras.cadastropessoasproducer.controller;

import br.com.feras.cadastropessoasproducer.configuration.validation.ValidarPessoa;
import br.com.feras.cadastropessoasproducer.domain.dto.PessoaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  @PostMapping
  public ResponseEntity<?> adicionar(@RequestBody PessoaDto pessoaDto){
    String erro = ValidarPessoa.validacao(pessoaDto);

    if(erro != null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pessoa adicionada com sucesso!");
  }
}
