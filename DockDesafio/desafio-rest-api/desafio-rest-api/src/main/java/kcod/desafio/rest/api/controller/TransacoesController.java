package kcod.desafio.rest.api.controller;


import kcod.desafio.rest.api.model.TransacoesModel;
import kcod.desafio.rest.api.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TransacoesController {

    @Autowired
    private TransacoesRepository transacoesRepository;

    public TransacoesController(TransacoesRepository transacoesRepository) {
        this.transacoesRepository = transacoesRepository;
    }

    public TransacoesModel adicionarTransacao(Integer idConta, Float valor, Date dataTransacao){

        TransacoesModel transacoes = new TransacoesModel();

        transacoes.setIdTransacao( (float) Math.random());

        transacoes.setValor(valor);

        transacoes.setData(dataTransacao);

        transacoes.setIdConta(idConta);

        return transacoesRepository.save(transacoes);

    }

    @GetMapping(path = "/api/transacoes/{id}")
    public ResponseEntity consultarTransacoes(@PathVariable("id") Integer id) {
        return transacoesRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }





}
