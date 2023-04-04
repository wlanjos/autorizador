package br.com.vrbeneficios.autorizador.controller;

import br.com.vrbeneficios.autorizador.controller.dto.CartaoRq;
import br.com.vrbeneficios.autorizador.controller.dto.DadoTransacao;
import br.com.vrbeneficios.autorizador.service.CartaoService;
import br.com.vrbeneficios.autorizador.service.TrasacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacoes")
public class TransacaoController {

  private final TrasacaoService trasacaoService;

  @PostMapping
  public ResponseEntity transacao(@RequestBody DadoTransacao dadoTransacao) {

    return trasacaoService.transacao(dadoTransacao);

  }




  }
