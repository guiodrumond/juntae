package br.com.juntaeapp.juntae.dto;

import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.model.StatusAluno;
import br.com.juntaeapp.juntae.service.AlunoService;
import jakarta.validation.constraints.NotNull;

public record RequisicaoNovoAluno(
        String matricula,
        @NotNull String nome,
        String curso,
        String etapa,
        String turma
) {

    public static RequisicaoNovoAluno defaultInstance() {
        return new RequisicaoNovoAluno("", "", "", "", "");
    }

    public Aluno toEntity(AlunoService service) {
        Aluno aluno = new Aluno();
        aluno.setMatricula(Long.valueOf(this.matricula()));
        aluno.setNome(this.nome());
        aluno.setCurso(this.curso());
        aluno.setEtapa(this.etapa());
        aluno.setTurma(this.turma());
        return aluno;
    }

}
