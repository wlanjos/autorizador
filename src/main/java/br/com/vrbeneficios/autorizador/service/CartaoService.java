package br.com.vrbeneficios.autorizador.service;

import br.com.vrbeneficios.autorizador.controller.dto.CartaoRs;
import br.com.vrbeneficios.autorizador.controller.dto.CartaoRq;
import br.com.vrbeneficios.autorizador.enums.TrascaoEnum;
import br.com.vrbeneficios.autorizador.model.Cartao;
import br.com.vrbeneficios.autorizador.repository.CartaoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartaoService {

  private final CartaoRepository repository;

  public ResponseEntity save(CartaoRq cartaoRq) {

    Optional<Cartao> byId = repository.findById(cartaoRq.getNumeroCartao());

    if (!byId.isPresent()) {
      var c = new Cartao();
      c.setNumeroCartao(cartaoRq.getNumeroCartao());
      c.setSenha(cartaoRq.getSenha());

      repository.save(c);

      ModelMapper modelMapper = new ModelMapper();
      CartaoRs response = modelMapper.map(c, CartaoRs.class);

      return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    return new ResponseEntity<>(cartaoRq, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  public ResponseEntity getSaldo(Long numCartao) {

    Optional<Cartao> cartao = repository.findById(numCartao);
    if (cartao.isPresent()) {

      ModelMapper modelMapper = new ModelMapper();
      CartaoRs response = modelMapper.map(cartao, CartaoRs.class);

      return new ResponseEntity<>(response.getSaldo(), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  public ResponseEntity addSaldo(Long numCartao, double deposito) {
    Optional<Cartao> cartao = repository.findById(numCartao);
    if (!cartao.isPresent()) {
      return new ResponseEntity<>(TrascaoEnum.CARTAO_INEXISTENTE,HttpStatus.UNPROCESSABLE_ENTITY);
    }
      Cartao cartao1 = cartao.get();
      cartao1.setSaldo(cartao1.getSaldo() + deposito );

      repository.save(cartao1);
    ModelMapper modelMapper = new ModelMapper();
    CartaoRs response = modelMapper.map(cartao1, CartaoRs.class);
    return new ResponseEntity<>(response.getSaldo(),HttpStatus.OK);

  }
}
