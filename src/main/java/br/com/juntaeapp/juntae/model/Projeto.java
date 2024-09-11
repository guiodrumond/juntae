package br.com.juntaeapp.juntae.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "projeto")
    private List<AlunoProjeto> alunoProjetos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<AlunoProjeto> getAlunoProjetos() {
        return alunoProjetos;
    }

    public void setAlunoProjetos(List<AlunoProjeto> alunoProjetos) {
        this.alunoProjetos = alunoProjetos;
    }
}
