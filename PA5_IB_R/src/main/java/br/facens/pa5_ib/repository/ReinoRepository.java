package br.facens.pa5_ib.repository;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import br.facens.pa5_ib.model.Reino;

@Repository
public class ReinoRepository {
    HashMap<Integer, Reino> reinos=new HashMap<Integer, Reino>();

    public ReinoRepository() {
        reinos.put(1, new Reino(1, "Animalia"));
        reinos.put(2, new Reino(2, "Plantae"));
        reinos.put(3, new Reino(3, "Fungi"));
        reinos.put(4, new Reino(4, "Protista"));
        reinos.put(5, new Reino(5, "Monera"));
    }//construtor

    
    public Reino getReinoById(Integer id) {
        return reinos.get(id);
    }


    public HashMap<Integer, Reino> getReinos() {
        return reinos;
    }
        
}
