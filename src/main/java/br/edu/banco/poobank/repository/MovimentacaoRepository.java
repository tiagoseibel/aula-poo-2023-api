package br.edu.banco.poobank.repository;

import br.edu.banco.poobank.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MovimentacaoRepository
        extends JpaRepository<Movimentacao, Integer> {

    @Query(value = "select sum(case when tipo='C' then valor else 0 end) - sum(case when tipo='D' then valor else 0 end) as saldo from movimentacao m where m.id_correntista = ?1", nativeQuery = true)
    BigDecimal getSaldo(Integer id);
}
