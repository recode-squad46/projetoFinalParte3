package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;

@Controller
public class ProfessorPageController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@GetMapping({"/listaProfessor"})
    public ModelAndView listaProfessor() {
        ModelAndView modelAndView = new ModelAndView("listaProfessor.html");
        modelAndView.addObject("listaDeProfessores",professorRepository.findAll());
        return modelAndView;
    }
	
	
	@GetMapping("/cadastroProfessor")
    public ModelAndView criarProfessor() {
		ModelAndView modelAndView = new ModelAndView("cadastroProfessor.html");
		modelAndView.addObject("professor",new Professor());
        return modelAndView;
    }
	
	@PostMapping("/cadastrarProfessor")
    public ModelAndView cadastrarProfessor(Professor professor){
		professorRepository.save(professor);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaProfessor");
		return modelAndView;
	}
	
	@GetMapping("/atualizarProfessor/{id}")
    public ModelAndView atualizarProfessor(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("formUpdateProfessor.html");
		Professor professor = professorRepository.getOne(id);
		modelAndView.addObject("professor", professor);
        return modelAndView;
    }
	
	@PostMapping("/atualizarProfessor")
    public ModelAndView alterarProfessor(Professor professor){
		professorRepository.atualizarProfessor(professor);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaProfessor");
		return modelAndView;
	}
	
	@GetMapping("/deletaProfessor/{id}")
    public ModelAndView deletaProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaProfessor");
        return modelAndView;
    }
	
}

