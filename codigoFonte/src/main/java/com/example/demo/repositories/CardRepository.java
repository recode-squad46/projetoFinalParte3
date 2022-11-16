package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

	@Modifying
    @Transactional
    @Query(value = "Update tb_card set nome = :#{#card.nome}, imgCard = :#{#card.imgCard} WHERE id = :#{#card.id} " , nativeQuery = true)
	void atualizarCard(@Param("card") Card card);
}
