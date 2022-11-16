package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	
	@Modifying
    @Transactional
    @Query(value = "Update tb_professor set nome = :#{#professor.nome}, email = :#{#professor.email}, senha = :#{#professor.senha} WHERE id = :#{#professor.id} " , nativeQuery = true)
	void atualizarProfessor(@Param("professor") Professor professor);
}
