package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.service.ComunidadeService;

@Controller
@RequestMapping("/home")
public class ComunidadeController {

    @Autowired
    private ComunidadeService cr;

    @GetMapping("/comunidade")
    public String cadastro()
    {
        return "comunidade";
    }

    @PostMapping("/comunidade")
    public ModelAndView ComunidadeView(@ModelAttribute Comunidade comunidade){
        ModelAndView mv = new ModelAndView("comunidade");
        cr.addComunidade(comunidade);
        mv.addObject("comunidades", cr.getTodasComunidades());
        return mv;
    }
    

}