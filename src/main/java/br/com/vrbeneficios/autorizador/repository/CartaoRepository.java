package br.com.vrbeneficios.autorizador.repository;

import br.com.vrbeneficios.autorizador.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao,Long> {

}
