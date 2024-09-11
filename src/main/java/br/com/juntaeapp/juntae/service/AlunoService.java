package br.com.juntaeapp.juntae.service;

import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public void cadastrar(Aluno novoCliente) {

        if (novoCliente == null) return;

        repository.save(novoCliente);

    }

}
