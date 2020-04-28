package br.facens.pa5_ib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.model.EstadoConservacao;
import br.facens.pa5_ib.model.Reino;
import br.facens.pa5_ib.model.SerVivo;
import br.facens.pa5_ib.repository.SerVivoRepository;

@Service
public class SerVivoService {

    @Autowired
    private SerVivoRepository svr;
    //private ReinoService rs;

    public void addSerVivo(SerVivo servivo, String reino, String EC) {
        svr.addSerVivo(servivo, reino, EC);
    }

    public ArrayList<SerVivo> getSeresVivos(){
        if(svr.getSerVivo().isEmpty()){
            return null;
        }
        return svr.getSerVivo();
    }

    public String procurarReino(int id, ArrayList<Reino> reino){
        for(Reino r : reino){
            if(r.getIdReino() == id){
                return r.getNomeReino();
            }
        }
        return null;
    }
    public String procurarEstadoConcervacao(int id, ArrayList<EstadoConservacao> EC){
        for(EstadoConservacao e : EC){
            if(e.getIdEstadoConservacao() == id){
                return e.getTipo();
            }
        }
        return null;
    }
}