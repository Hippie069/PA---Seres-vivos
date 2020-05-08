package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.facens.pa5_ib.service.EstadoConservacaoService;

@Controller
@RequestMapping("/home")
public class EstadoConservacaoController{


    @Autowired
    private EstadoConservacaoService ecs;

    @GetMapping("/estadosconservacao")
    public ModelAndView getEstadoConservacao(){
         ModelAndView mv = new ModelAndView ("estadoConservacaoView");

        mv.addObject("estadosconservacao", ecs.getEstadoDeConservacao());
        return mv;
    }

}