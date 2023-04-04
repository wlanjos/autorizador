package br.com.vrbeneficios.autorizador.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadoTransacao {

  private Long numeroCartao;
  private Integer senha;
  private double valor;
}
