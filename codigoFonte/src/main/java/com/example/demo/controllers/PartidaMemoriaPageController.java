package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.PartidaMemoria;
import com.example.demo.repositories.PartidaMemoriaRepository;
import com.example.demo.repositories.AlunoRepository;

@Controller
public class PartidaMemoriaPageController {

	@Autowired
	private PartidaMemoriaRepository partidaMemoriaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	

	@GetMapping({"/listaPartidaMemoria"})
    public ModelAndView listaPartidaMemoria() {
        ModelAndView modelAndView = new ModelAndView("listaPartidaMemoria.html");
        modelAndView.addObject("listaDePartidasMemoria",partidaMemoriaRepository.findAll());
        return modelAndView;
    }
	
	
	@GetMapping("/cadastroPartidaMemoria")
    public ModelAndView criarPartidaMemoria() {
		ModelAndView modelAndView = new ModelAndView("cadastroPartidaMemoria.html");
		modelAndView.addObject("partidaMemoria",new PartidaMemoria());
        return modelAndView;
    }
	
	@PostMapping("/cadastrarPartidaMemoria")
    public ModelAndView cadastrarPartidaMemoria(PartidaMemoria partidaMemoria){
		partidaMemoria.setAluno(alunoRepository.getOne((long) 1));
		partidaMemoriaRepository.save(partidaMemoria);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaPartidaMemoria");
		return modelAndView;
	}
	
	@GetMapping("/atualizarPartidaMemoria/{id}")
    public ModelAndView atualizarPartidaMemoria(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("formUpdatePartidaMemoria.html");
		PartidaMemoria partidaMemoria = partidaMemoriaRepository.getOne(id);
		modelAndView.addObject("partidaMemoria", partidaMemoria);
        return modelAndView;
    }
	
	@PostMapping("/atualizarPartidaMemoria")
    public ModelAndView alterarPartidaMemoria(PartidaMemoria partidaMemoria){
		partidaMemoriaRepository.atualizarPartidaMemoria(partidaMemoria);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaPartidaMemoria");
		return modelAndView;
	}
	
	@GetMapping("/deletaPartidaMemoria/{id}")
    public ModelAndView deletaPartidaMemoria(@PathVariable Long id) {
		partidaMemoriaRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaPartidaMemoria");
        return modelAndView;
    }
	
}
