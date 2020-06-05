package br.facens.pa5_ib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.model.SerVivo;
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

    @GetMapping("/associar/{id}")
    public ModelAndView associar(@PathVariable (name="id") Integer id){
        ModelAndView mv = new ModelAndView("SerVivoComunidades");
        Comunidade comunidade = cr.getComunidadeById(id);
        List<SerVivo> serVivo = svs.getSeresVivos();

        mv.addObject("comunidade", comunidade);        
        mv.addObject("serVivo", serVivo);

        return mv;
    }

    @PostMapping("/associarservivo")
    public String associarComunidade(HttpServletRequest req , @RequestParam Integer cod) {

        Comunidade comunidade = cr.getComunidadeById(cod);
        SerVivo servivo = svs.getSerVivoById(Integer.parseInt(req.getParameter("id")));

        comunidade.getSerVivo().add(servivo);
        cr.addComunidade(comunidade);

        return "redirect:/home/associar/" + cod;
    }

}