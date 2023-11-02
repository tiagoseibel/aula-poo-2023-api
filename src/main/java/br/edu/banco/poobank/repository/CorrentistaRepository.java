package br.edu.banco.poobank.repository;

import br.edu.banco.poobank.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorrentistaRepository
        extends JpaRepository<Correntista, Integer> {

    public Correntista findByCpf(String cpf);
    public Correntista findByChavePix(String chavePix);

//    @Query(value = "select * from correntistas where nome like ?", nativeQuery = true)
//    public List<Correntista> pesquisarCorrentistas(String nome);
}
