package br.facens.pa5_ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.facens.pa5_ib.service.ReinoService;

@Controller
@RequestMapping("/home")
public class ReinoController {
    
    @Autowired
    private ReinoService rs;

    @GetMapping("/reinos")
    public ModelAndView getReinos() {
        ModelAndView mv=new ModelAndView("reinoView");

        //rs.addReino();

        mv.addObject("reinos", rs.getReinos());
        return mv;
    }//getReinos
}
