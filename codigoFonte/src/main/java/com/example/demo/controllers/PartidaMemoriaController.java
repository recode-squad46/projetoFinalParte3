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
import com.example.demo.entities.PartidaMemoria;
import com.example.demo.entities.Aluno;
import com.example.demo.repositories.PartidaMemoriaRepository;
import com.example.demo.repositories.AlunoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PartidaMemoriaController {

	
	
	@Autowired
	private PartidaMemoriaRepository partidaMemoriaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	//READ ou GET all
	
	@GetMapping("/partidasMemoria")
	public List<PartidaMemoria> getAllPartidasMemoria(){
		return partidaMemoriaRepository.findAll();
	}
	
	//READ ou GET by id
	
	@GetMapping("/partidasMemoria/{id}")
	public ResponseEntity<PartidaMemoria> getPartidaMemoriaById(@PathVariable Long id){
		PartidaMemoria partidaMemoria = partidaMemoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PartidaMemoria inexistente"));
		return ResponseEntity.ok(partidaMemoria);
	}
	
	//POST ou CREATE
	@PostMapping("/partidasMemoria")
	public PartidaMemoria createPartidaMemoria(@RequestBody PartidaMemoria partidaMemoria) {
		return partidaMemoriaRepository.save(partidaMemoria);
	}
	
	
	
	//PUT ou UPDATE
	@PutMapping("/partidasMemoria/{id}")
	public ResponseEntity<PartidaMemoria> updatePartidaMemoria(@PathVariable Long id, @RequestBody PartidaMemoria partidasMemoriaDetails){
		
		PartidaMemoria partidaMemoria = partidaMemoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PartidaMemoria Inexistente"));
		Aluno aluno	= alunoRepository.findById(partidasMemoriaDetails.getAluno().getId()).get();
		
		partidaMemoria.setTempoPartida(partidasMemoriaDetails.getTempoPartida());
		partidaMemoria.setQuantidadeJogadas(partidasMemoriaDetails.getQuantidadeJogadas());
		partidaMemoria.setAluno(aluno);
		
		PartidaMemoria newPartidaMemoria = partidaMemoriaRepository.save(partidaMemoria);
		
		return ResponseEntity.ok(newPartidaMemoria);
	}
	
	//DELETE
	@DeleteMapping("/partidasMemoria/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePartidaMemoria(@PathVariable Long id){
		
		PartidaMemoria partidaMemoria = partidaMemoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("PartidaMemoria Inexistente"));
		
		partidaMemoriaRepository.delete(partidaMemoria);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

