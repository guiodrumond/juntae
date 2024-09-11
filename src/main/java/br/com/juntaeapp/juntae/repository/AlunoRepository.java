package br.com.juntaeapp.juntae.repository;


import br.com.juntaeapp.juntae.model.Aluno;
import br.com.juntaeapp.juntae.model.StatusAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByStatusAluno(StatusAluno statusPedido);
}
