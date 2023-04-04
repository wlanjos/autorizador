package br.com.vrbeneficios.autorizador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartao")
public class Cartao {

  @Id
  private Long numeroCartao;
  @Column(name="senha")
  private String senha;
  @Column(name="saldo")
  private double saldo;
}
