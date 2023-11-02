package br.edu.banco.poobank.controller;

import br.edu.banco.poobank.model.Correntista;
import br.edu.banco.poobank.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntista")
@CrossOrigin("*")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @GetMapping
    public List<Correntista> all() {
        return repository.findAll();
    }

    @GetMapping("/entrar/{cpf}")
    public ResponseEntity entrar(@PathVariable String cpf) {
        Correntista correntista = repository.findByCpf(cpf);
        return ResponseEntity.ok(correntista);
    }

    @PostMapping
    public ResponseEntity criarConta(@RequestBody Correntista correntista) {
        repository.save(correntista);
        return ResponseEntity.ok().build();
    }
}
