package br.edu.banco.poobank.controller;

import br.edu.banco.poobank.dto.PixDTO;
import br.edu.banco.poobank.repository.MovimentacaoRepository;
import br.edu.banco.poobank.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/movimentacao")
@CrossOrigin("*")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping("/{id}")
    public ResponseEntity getSaldo(@PathVariable Integer id) {
        BigDecimal saldo = repository.getSaldo(id);
        return ResponseEntity.ok(saldo);
    }

    @PostMapping("/pix")
    public ResponseEntity pix(@RequestBody PixDTO pix) {
        service.processarPix(pix);
        return ResponseEntity.ok().build();
    }
}
