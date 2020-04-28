package br.facens.pa5_ib.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.facens.pa5_ib.service.IndiceShannonCalculoService;

@Controller
@RequestMapping("/home")
public class IndiceShannonController {
    
    @Autowired
    private IndiceShannonCalculoService iscs;

    @GetMapping("/calcshannon")
    public ModelAndView calcular(){
        ModelAndView mv = new ModelAndView("IndiceShannonView");

        Integer N = 0, i = 0;
        ArrayList<Integer> Pi = new ArrayList<>();
        ArrayList<Double> Piln = new ArrayList<>();
        Double H = 0.0;

        N = iscs.contabilizarTotalIndividuos();

        do {
            Pi.add(( ((iscs.contabilizarDimensaoEspaco(i))/N)));
            i++;
        } while (i <= iscs.contabilizarEspecies());

        for (int j = 0; j < iscs.contabilizarEspecies(); j++) {
            Piln.add(Pi.get(j)*(Math.log(Pi.get(j))));
        }

        for (int j = 0; j < iscs.contabilizarEspecies(); j++) {
            H = H + Piln.get(j);
        }
        
        H = H * (-1);
        
        iscs.addIndice(H);

        mv.addObject("Indices", iscs.getTodosIndices());
        
        return mv;
    }
}