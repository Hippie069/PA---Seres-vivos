package br.facens.pa5_ib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.facens.pa5_ib.model.SerVivo;
import br.facens.pa5_ib.repository.SerVivoRepository;

@Service
public class SerVivoService {

    @Autowired
    private SerVivoRepository svr;
    
    public void addSerVivo(SerVivo serVivo) {
        svr.save(serVivo);
    }
    
    public List<SerVivo> getSeresVivos(){
     return svr.findAll();
    }

    public SerVivo getSerVivoById(int id) {
        return svr.findById(id).get();
    }

}