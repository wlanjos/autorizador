package br.com.vrbeneficios.autorizador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartaoRq {

  private Long numeroCartao;
  private String senha;
}
