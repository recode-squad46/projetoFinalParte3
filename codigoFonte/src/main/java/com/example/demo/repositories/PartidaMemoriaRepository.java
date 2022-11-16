package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.PartidaMemoria;

public interface PartidaMemoriaRepository extends JpaRepository<PartidaMemoria, Long>{

	@Modifying
    @Transactional
    @Query(value = "Update tb_partida_memoria set qtd_jogadas = :#{#partidaMemoria.qtdJogadas}, tempo_partida = :#{#partidaMemoria.tempoPartida} WHERE id = :#{#partidaMemoria.id} " , nativeQuery = true)
	void atualizarPartidaMemoria(@Param("partidaMemoria") PartidaMemoria partidaMemoria);
}
