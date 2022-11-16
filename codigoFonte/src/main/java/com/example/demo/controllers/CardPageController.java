package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Card;
import com.example.demo.repositories.CardRepository;
import com.example.demo.repositories.ProfessorRepository;

@Controller
public class CardPageController {

	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@GetMapping({"/listaCard"})
    public ModelAndView listaCard() {
        ModelAndView modelAndView = new ModelAndView("listaCard.html");
        modelAndView.addObject("listaDeCards",cardRepository.findAll());
        return modelAndView;
    }
	
	
	@GetMapping("/cadastroCard")
    public ModelAndView criarCard() {
		ModelAndView modelAndView = new ModelAndView("cadastroCard.html");
		modelAndView.addObject("card",new Card());
        return modelAndView;
    }
	
	@PostMapping("/cadastrarCard")
    public ModelAndView cadastrarCard(Card card){
		card.setProfessor(professorRepository.getOne((long) 1));
		cardRepository.save(card);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaCard");
		return modelAndView;
	}
	
	@GetMapping("/atualizarCard/{id}")
    public ModelAndView atualizarCard(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("formUpdateCard.html");
		Card card = cardRepository.getOne(id);
		modelAndView.addObject("card", card);
        return modelAndView;
    }
	
	@PostMapping("/atualizarCard")
    public ModelAndView alterarCard(Card card){
		cardRepository.atualizarCard(card);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaCard");
		return modelAndView;
	}
	
	@GetMapping("/deletaCard/{id}")
    public ModelAndView deletaCard(@PathVariable Long id) {
		cardRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/listaCard");
        return modelAndView;
    }
	
}
