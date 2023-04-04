package br.com.vrbeneficios.autorizador.service;

import br.com.vrbeneficios.autorizador.controller.dto.DadoTransacao;
import br.com.vrbeneficios.autorizador.enums.TrascaoEnum;
import br.com.vrbeneficios.autorizador.model.Cartao;
import br.com.vrbeneficios.autorizador.repository.CartaoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrasacaoService {

  private final CartaoRepository repository;

  public ResponseEntity transacao(DadoTransacao dadoTransacao) {
    Optional<Cartao> cartao = repository.findById(dadoTransacao.getNumeroCartao());

    if (!cartao.isPresent()) {

      return new ResponseEntity<>(TrascaoEnum.CARTAO_INEXISTENTE,HttpStatus.UNPROCESSABLE_ENTITY);

    }else if(!cartao.get().getSenha().equals(dadoTransacao.getSenha())){

      return new ResponseEntity<>(TrascaoEnum.SENHA_INVALIDA,HttpStatus.UNPROCESSABLE_ENTITY);

    }else if (cartao.get().getSaldo() <= dadoTransacao.getValor()){

      return new ResponseEntity<>(TrascaoEnum.SALDO_INSUFICIENTE,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    Cartao cartao1 = cartao.get();
    cartao1.setSaldo(cartao1.getSaldo() - dadoTransacao.getValor());

    repository.save(cartao1);
    return new ResponseEntity<>("OK",HttpStatus.OK);
  }
}
