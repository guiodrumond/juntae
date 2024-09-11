package br.com.juntaeapp.juntae.dto;

import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.model.StatusAluno;
import br.com.juntaeapp.juntae.service.AlunoService;
import jakarta.validation.constraints.NotNull;

public record RequisicaoNovoAluno(
        Long id,
        Long matricula,
        StatusAluno statusAluno,
        @NotNull String nome,
        String curso,
        String etapa,
        String turma
) {

    public Aluno toEntity(AlunoService service) {
        Aluno aluno = new Aluno();
        aluno.setId(this.id());
        aluno.setMatricula(this.matricula());
        aluno.setStatusAluno(this.statusAluno());
        aluno.setNome(this.nome());
        aluno.setCurso(this.curso());
        aluno.setEtapa(this.etapa());
        aluno.setTurma(this.turma());
        return aluno;
    }

}
