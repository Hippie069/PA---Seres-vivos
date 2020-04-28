package br.facens.pa5_ib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.model.Comunidade;
import br.facens.pa5_ib.repository.ComunidadeRepository;

@Service
public class ComunidadeService {

@Autowired
private ComunidadeRepository cr;

public void addComunidade(Comunidade comunidade) {
    cr.addComunidades(comunidade);;
}

public ArrayList<Comunidade> getTodasComunidades(){
    
    if(cr.getComunidades().isEmpty())
    return null;
    
 return cr.getComunidades();
}


}