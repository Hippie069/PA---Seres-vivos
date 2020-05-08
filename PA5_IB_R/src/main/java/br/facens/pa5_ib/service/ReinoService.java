package br.facens.pa5_ib.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.facens.pa5_ib.model.Reino;
import br.facens.pa5_ib.repository.ReinoRepository;

@Service
public class ReinoService {
    
    @Autowired
    private ReinoRepository reino;

    public List<Reino> getReinos(){
        if(reino.count() == 0){
            reino.save(new Reino("Animalia"));
            reino.save(new Reino("Plantae"));
            reino.save(new Reino("Fungi"));
            reino.save(new Reino("Protista"));
            reino.save(new Reino("Monera"));
        }
        return reino.findAll();
    }


    public Reino getReinoById(Integer id) {
        return reino.findById(id).get();
    }   
}