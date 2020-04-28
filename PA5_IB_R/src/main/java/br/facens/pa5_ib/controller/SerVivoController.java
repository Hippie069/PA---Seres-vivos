package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import br.facens.pa5_ib.model.SerVivo;
import br.facens.pa5_ib.service.EstadoConservacaoService;
import br.facens.pa5_ib.service.ReinoService;
import br.facens.pa5_ib.service.SerVivoService;

@Controller
@RequestMapping("/home")
public class SerVivoController {

    @Autowired
    private SerVivoService svs;

    @Autowired
    private EstadoConservacaoService ecs;

    @Autowired
    private ReinoService rs;
    
    @GetMapping("/servivo")
    public String serVivo(){
        return "serVivoView";
    }

    @PostMapping("/servivo")
    public ModelAndView SerVivoView(@ModelAttribute SerVivo servivo, HttpServletRequest req){
        ModelAndView mv = new ModelAndView ("serVivoView");
        int idr = Integer.parseInt(req.getParameter("Reino"));
        int ide = Integer.parseInt(req.getParameter("EstadoConservacao"));
        svs.addSerVivo(servivo, svs.procurarReino(idr, rs.getReinos()), svs.procurarEstadoConcervacao(ide, ecs.getEstadosConversavacao()));
        mv.addObject("seresvivos", svs.getSeresVivos());
        return mv;
    }


}