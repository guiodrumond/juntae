package br.com.juntaeapp.juntae.controller;

import br.com.juntaeapp.juntae.dto.RequisicaoNovoAluno;
import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.repository.AlunoRepository;
import br.com.juntaeapp.juntae.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @Autowired
    AlunoService service;

    @GetMapping("cadastro")
    public String formulario(Model model) {
        model.addAttribute("requisicaoNovoAluno", RequisicaoNovoAluno.defaultInstance());
        model.addAttribute("alunos", repository.findAll());
        return "alunos/cadastro";
    }

    @PostMapping("novo")
    public String cadastra(@ModelAttribute @Valid RequisicaoNovoAluno form, BindingResult result, RedirectAttributes attributes) {

        if (result.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/alunos/cadastro";
        }

        try {
            Aluno novoAluno = form.toEntity(service);
            service.cadastrar(novoAluno);

            attributes.addFlashAttribute("success", "Aluno cadastrado com sucesso!");
            return "redirect:/alunos/cadastro";

        } catch (IllegalArgumentException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/alunos/cadastro";
        }
    }
}
