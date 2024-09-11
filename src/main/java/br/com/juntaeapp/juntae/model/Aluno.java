package br.com.juntaeapp.juntae.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matricula;

    @Enumerated(EnumType.STRING)
    private StatusAluno statusAluno;

    private String nome;

    private String curso;

    private String etapa;

    private String turma;

    @OneToMany(mappedBy = "aluno")
    private List<AlunoProjeto> alunoProjetos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public StatusAluno getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(StatusAluno statusAluno) {
        this.statusAluno = statusAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<AlunoProjeto> getAlunoProjetos() {
        return alunoProjetos;
    }

    public void setAlunoProjetos(List<AlunoProjeto> alunoProjetos) {
        this.alunoProjetos = alunoProjetos;
    }

    public Aluno() {
    }
}
