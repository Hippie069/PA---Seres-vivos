package br.facens.pa5_ib.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.facens.pa5_ib.model.Reino;
import br.facens.pa5_ib.repository.ReinoRepository;

@Service
public class ReinoService {
    
    @Autowired
    private ReinoRepository reino;

    public Reino getReinoById(Integer id) {
        return reino.getReinoById(id);
    }
    
    public ArrayList<Reino> getReinos(){
        HashMap<Integer, Reino> reinos=reino.getReinos();
        ArrayList<Reino> returnedReinos=new ArrayList<Reino>();

        
        for(Reino r:reinos.values()) {
            returnedReinos.add(r);
        }//for

        return returnedReinos;
    }
}