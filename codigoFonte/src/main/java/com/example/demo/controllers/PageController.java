package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {

	
	@GetMapping({"", "/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }
	
	@GetMapping({"/sobre"})
    public ModelAndView sobre() {
        ModelAndView modelAndView = new ModelAndView("sobre.html");
        return modelAndView;
    }
	
	@GetMapping({"/comoUsar"})
    public ModelAndView comoUsar() {
        ModelAndView modelAndView = new ModelAndView("comoUsar.html");
        return modelAndView;
    }
	
	@GetMapping({"/comoCadastrar"})
    public ModelAndView comoCadastrar() {
        ModelAndView modelAndView = new ModelAndView("comoCadastrar.html");
        return modelAndView;
    }
	
	@GetMapping({"/nossoProjeto"})
    public ModelAndView nossoProjeto() {
        ModelAndView modelAndView = new ModelAndView("nossoProjeto.html");
        return modelAndView;
    }
	
	@GetMapping({"/partidaMemoriaJogo"})
    public ModelAndView partidaMemoriaJogo() {
        ModelAndView modelAndView = new ModelAndView("partidaMemoriaJogo.html");
        return modelAndView;
    }
	
	@GetMapping({"/partidaMemoriaResultado"})
    public ModelAndView partidaMemoriaResultado() {
        ModelAndView modelAndView = new ModelAndView("partidaMemoriaResultado.html");
        return modelAndView;
    }
	@GetMapping({"/main"})
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("assets/style/main.css");
        return modelAndView;
    }
	
	
}
