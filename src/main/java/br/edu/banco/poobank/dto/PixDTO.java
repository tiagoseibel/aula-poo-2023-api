package br.edu.banco.poobank.dto;

import br.edu.banco.poobank.model.Correntista;

import java.math.BigDecimal;

public class PixDTO {
    private Correntista correntista;
    private BigDecimal valor;
    private String chave;

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
