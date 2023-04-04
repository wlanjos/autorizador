package br.com.vrbeneficios.autorizador.controller;

import br.com.vrbeneficios.autorizador.controller.dto.CartaoRq;
import br.com.vrbeneficios.autorizador.controller.dto.DadoTransacao;
import br.com.vrbeneficios.autorizador.service.CartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cartoes")
public class CartaoController {

  private final CartaoService cartaoService;


  @PutMapping("/saldo/{numCartao}")
  public ResponseEntity addSaldo(@PathVariable Long numCartao,@RequestParam("deposito") double deposito){

    return cartaoService.addSaldo(numCartao,deposito );
  }

@PostMapping
  public ResponseEntity create(@RequestBody CartaoRq cartaoRq){

    return cartaoService.save(cartaoRq);
  }

  @GetMapping("/{numCartao}")
  public ResponseEntity getSaldo(@PathVariable Long numCartao){

    return cartaoService.getSaldo(numCartao);
  }


  }
