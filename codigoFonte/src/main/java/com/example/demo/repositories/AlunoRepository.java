package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	@Modifying
    @Transactional
    @Query(value = "Update tb_aluno set nome = :#{#aluno.nome} WHERE id = :#{#aluno.id} " , nativeQuery = true)
	void atualizarAluno(@Param("aluno") Aluno aluno);
}
