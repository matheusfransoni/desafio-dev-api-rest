package kcod.desafio.rest.api.controller;

import kcod.desafio.rest.api.model.ContaModel;
import kcod.desafio.rest.api.repository.ContaRepository;
import kcod.desafio.rest.api.repository.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @Autowired
    private TransacoesRepository transacoesRepository;

    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/api/usuario/saldo/{id}")
    public String consultarSaldo(@PathVariable("id") Integer id) {

        ContaModel conta = repository.findById(id).get();

        return conta.getSaldo().toString();
    }


    @PostMapping(path = "/api/usuario/salvar")
    public ContaModel salvar(@RequestBody ContaModel conta){
        return repository.save(conta);
    }

    @PostMapping(path = "/api/usuario/adicionarSaldo")
    public ContaModel adicionar(@RequestBody ContaModel conta){

        Integer id = conta.getIdConta();

        Float valor = conta.getSaldo();

        ContaModel saldo = repository.findById(id).get();

        Float novoSaldo = saldo.getSaldo() + valor;

        saldo.setSaldo(novoSaldo);

        TransacoesController transacoesController = new TransacoesController(transacoesRepository);

        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());


        transacoesController.adicionarTransacao(id,valor, date);

        return repository.save(saldo);

    }

    @PostMapping(path = "/api/usuario/sacar")
    public ContaModel sacar(@RequestBody ContaModel conta){

        Integer id = conta.getIdConta();

        Float valor = conta.getSaldo();

        ContaModel saldo = repository.findById(id).get();

        Float novoSaldo = saldo.getSaldo() - valor;

        saldo.setSaldo(novoSaldo);

        TransacoesController transacoesController = new TransacoesController(transacoesRepository);

        java.sql.Timestamp data = new java.sql.Timestamp(new java.util.Date().getTime());


        transacoesController.adicionarTransacao(id,valor, data);

        return repository.save(saldo);

    }

    @PostMapping(path = "/api/usuario/bloquear")
    public ContaModel bloquear(@RequestBody ContaModel conta){

        Integer id = conta.getIdConta();

        ContaModel bloquear = repository.findById(id).get();

        bloquear.setFlagAtivo(false);

        return repository.save(bloquear);

    }

}
