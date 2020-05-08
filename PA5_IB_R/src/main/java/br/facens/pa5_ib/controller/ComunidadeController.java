package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.service.ComunidadeService;
import br.facens.pa5_ib.service.SerVivoService;

@Controller
@RequestMapping("/home")
public class ComunidadeController {

    @Autowired
    private ComunidadeService cr;

    @Autowired
    private SerVivoService svs;

    @GetMapping("/comunidade")
    public ModelAndView cadastro()
    {
        ModelAndView mv = new ModelAndView("comunidade");
        mv.addObject("comunidade", new Comunidade());
        mv.addObject("comunidades", cr.getTodasComunidades());
        return mv;
    }

    
    @PostMapping("/salvarcomunidade")
    public String ComunidadeView(@ModelAttribute Comunidade comunidade){
        cr.addComunidade(comunidade);

        return "redirect:/home/comunidade"; 
    }

}