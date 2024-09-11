package br.com.juntaeapp.juntae.model;

import jakarta.persistence.*;

@Entity
public class AlunoProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

}
