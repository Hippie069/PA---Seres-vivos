package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.model.SerVivo;
import br.facens.pa5_ib.service.ComunidadeService;
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

    @Autowired
    private ComunidadeService cs;

    @GetMapping("/servivo")
    public ModelAndView SerVivoView(){
        ModelAndView mv = new ModelAndView ("serVivoView");
        
        mv.addObject("servivo", new SerVivo());
        mv.addObject("seresvivos", svs.getSeresVivos());
        mv.addObject("reinos", rs.getReinos());
        mv.addObject("estadosconservacao", ecs.getEstadoDeConservacao());
        return mv;
    } 

    @PostMapping("/salvarservivo")
    public String serVivo(@ModelAttribute SerVivo servivo){
        svs.addSerVivo(servivo);

        return "redirect:/home/servivo";
    }

    @GetMapping("/associados/{id}")
    public ModelAndView associados(@PathVariable(name="id") Integer id){
        ModelAndView mv = new ModelAndView("listaComunidades");
        SerVivo serVivo = svs.getSerVivoById(id);
        List<Comunidade> comunidade = cs.getTodasComunidades();


        mv.addObject("servivo", serVivo);
        mv.addObject("comunidades", comunidade);

        return mv;
    }
}