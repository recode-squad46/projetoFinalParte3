package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Aluno;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.ProfessorRepository;

@Controller
public class AlunoPageController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@GetMapping({"/listaAluno"})
    public ModelAndView listaAluno() {
        ModelAndView modelAndView = new ModelAndView("listaAluno.html");
        modelAndView.addObject("listaDeAlunos",alunoRepository.findAll());
        return modelAndView;
    }
	
	
	@GetMapping("/cadastroAluno")
    public ModelAndView criarAluno() {
		ModelAndView modelAndView = new ModelAndView("cadastroAluno.html");
		modelAndView.addObject("aluno",new Aluno());
        return modelAndView;
    }
	
	@PostMapping("/cadastrarAluno")
    public ModelAndView cadastrarAluno(Aluno aluno){
		aluno.setProfessor(professorRepository.getOne((long) 1));
		alunoRepository.save(aluno);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaAluno");
		return modelAndView;
	}
	
	@GetMapping("/atualizarAluno/{id}")
    public ModelAndView atualizarAluno(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("formUpdateAluno.html");
		Aluno aluno = alunoRepository.getOne(id);
		modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }
	
	@PostMapping("/atualizarAluno")
    public ModelAndView alterarAluno(Aluno aluno){
		alunoRepository.atualizarAluno(aluno);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaAluno");
		return modelAndView;
	}
	
	@GetMapping("/deletaAluno/{id}")
    public ModelAndView deletaAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaAluno");
        return modelAndView;
    }
	
}
