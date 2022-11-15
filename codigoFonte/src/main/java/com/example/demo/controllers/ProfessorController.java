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
import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProfessorController {

	
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/professores")
	public List<Professor> getAllProfessores(){
		return professorRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/professores/{id}")
	public ResponseEntity<Professor> getProfessorById(@PathVariable Long id){
		Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor inexistente"));
		return ResponseEntity.ok(professor);
	}
	
	//POST ou CREATE
	@PostMapping("/professores")
	public Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/professores/{id}")
	public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professoresDetails){
		
		Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor Inexistente"));
		
		professor.setNome(professoresDetails.getNome());
		professor.setEmail(professoresDetails.getEmail());
		professor.setSenha(professoresDetails.getSenha());
		
		Professor newProfessor = professorRepository.save(professor);
		
		return ResponseEntity.ok(newProfessor);
	}
	
	//DELETE
	@DeleteMapping("/professores/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProfessor(@PathVariable Long id){
		
		Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor Inexistente"));
		
		professorRepository.delete(professor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
