package kcod.desafio.rest.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "conta")

public class ContaModel {

    @Id
    public Integer idConta;

    @Column(nullable = false, length = 50)
    public Integer idPessoa;

    @Column(nullable = false, length = 50)
    public Float saldo;

    @Column(nullable = false, length = 50)
    public Float limiteSaqueDiario;

    @Column(nullable = false, length = 50)
    public Boolean flagAtivo;

    @Column(nullable = false, length = 50)
    public Integer tipoConta;

    @Column(nullable = false, length = 50)
    @JsonFormat(pattern="dd/MM/yyyy")
    public Date Data;

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public Float getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(Float limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public Boolean getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(Boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public Integer getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Integer tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }
}
