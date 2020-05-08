package br.facens.pa5_ib.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.repository.ComunidadeRepository;

@Service
public class ComunidadeService {

    @Autowired
    private ComunidadeRepository cr;

    public void addComunidade(Comunidade comunidade) {
        cr.save(comunidade);
    }


    public List<Comunidade> getTodasComunidades(){
        return cr.findAll();
    }

    public Comunidade getComunidadeById(int id) {
        return cr.findById(id).get();
    }


}