package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entities.Card;
import com.example.demo.entities.Professor;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.ProfessorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CardController {

	
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	//READ ou GET all
	
	@GetMapping("/cards")
	public List<Card> getAllCards(){
		return cardRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/cards/{id}")
	public ResponseEntity<Card> getCardById(@PathVariable Long id){
		Card card = cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card inexistente"));
		return ResponseEntity.ok(card);
	}
	
	//POST ou CREATE
	@PostMapping("/cards")
	public Card createCard(@RequestBody Card card) {
		return cardRepository.save(card);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/cards/{id}")
	public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardsDetails){
		
		Card card = cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card Inexistente"));
		Professor	professor	= professorRepository.findById(cardsDetails.getProfessor().getId()).get();
		
		card.setNome(cardsDetails.getNome());
		card.setImgCard(cardsDetails.getImgCard());
		card.setProfessor(professor);

		
		Card newCard = cardRepository.save(card);
		
		return ResponseEntity.ok(newCard);
	}
	
	//DELETE
	@DeleteMapping("/cards/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCard(@PathVariable Long id){
		
		Card card = cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Card Inexistente"));
		
		cardRepository.delete(card);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}


