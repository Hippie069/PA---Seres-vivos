package br.facens.pa5_ib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.model.Participa;
import br.facens.pa5_ib.repository.ParticipaRepository;

@Service
public class ParticipaService {
    @Autowired
    private ParticipaRepository pr;
    
    public void addSerVivo(Participa participa) {
        pr.save(participa);
    }
    
    public List<Participa> getParticipa(){
     return pr.findAll();
    }

    public Participa getCursoById(int id) {
        return pr.findById(id).get();
    }
}