package br.com.juntaeapp.juntae.controller;

import br.com.juntaeapp.juntae.dto.RequisicaoNovoAluno;
import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.repository.AlunoRepository;
import br.com.juntaeapp.juntae.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @Autowired
    AlunoService service;

    @GetMapping("cadastro")
    public String formulario(RequisicaoNovoAluno requisicao) {
        return "aluno/cadastro";
    }

    @PostMapping("novo")
    public ResponseEntity cadastra(@ModelAttribute @Valid RequisicaoNovoAluno form, BindingResult result) {

        if (result.hasFieldErrors()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            Aluno novoAluno = form.toEntity(service);
            service.cadastrar(novoAluno);

            return ResponseEntity.ok().build();

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}
