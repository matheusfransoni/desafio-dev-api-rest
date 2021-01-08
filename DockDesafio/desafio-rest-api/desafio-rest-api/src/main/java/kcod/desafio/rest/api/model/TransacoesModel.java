package kcod.desafio.rest.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "transacoes")

public class TransacoesModel {


    @Column(nullable = false, length = 50)
    public Float idTransacao;

    @Id
    public Integer idConta;

    @Column(nullable = false, length = 50)
    public Float valor;

    @Column(nullable = false, length = 50)
    @JsonFormat(pattern="dd/MM/yyyy")
    public Date data;

    public Float getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Float idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
