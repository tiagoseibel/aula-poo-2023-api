package br.edu.banco.poobank.service;

import br.edu.banco.poobank.dto.PixDTO;
import br.edu.banco.poobank.model.Correntista;
import br.edu.banco.poobank.model.Movimentacao;
import br.edu.banco.poobank.repository.CorrentistaRepository;
import br.edu.banco.poobank.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class MovimentacaoService {

    @Autowired
    private CorrentistaRepository correntistaRepository;
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Transactional
    public void processarPix(PixDTO dto) {
        Correntista destinatario = correntistaRepository
                .findByChavePix(dto.getChave());

        // enviando
        Movimentacao m1 = new Movimentacao();
        m1.setCorrentista(dto.getCorrentista());
        m1.setDataMovimentacao(new Date());
        m1.setValor(dto.getValor());
        m1.setTipo("D");
        m1.setHistorico("PIX ENVIADO");

        movimentacaoRepository.save(m1);

        // recebendo
        Movimentacao m2 = new Movimentacao();
        m2.setCorrentista(destinatario);
        m2.setDataMovimentacao(new Date());
        m2.setValor(dto.getValor());
        m2.setTipo("C");
        m2.setHistorico("PIX RECEBIDO");

        movimentacaoRepository.save(m2);
    }
}
