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
import com.example.demo.entities.Aluno;
import com.example.demo.entities.Professor;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.ProfessorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlunoController {

	
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/alunos/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id){
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno inexistente"));
		return ResponseEntity.ok(aluno);
	}
	
	//POST ou CREATE
	@PostMapping("/alunos")
	public Aluno createAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/alunos/{id}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno alunosDetails){
		
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno Inexistente"));
		Professor professor	= professorRepository.findById(alunosDetails.getProfessor().getId()).get();
		
		aluno.setNome(alunosDetails.getNome());
		aluno.setProfessor(professor);
		
		Aluno newAluno = alunoRepository.save(aluno);
		
		return ResponseEntity.ok(newAluno);
	}
	
	//DELETE
	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAluno(@PathVariable Long id){
		
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aluno Inexistente"));
		
		alunoRepository.delete(aluno);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
