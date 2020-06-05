package br.facens.pa5_ib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.model.EstadoConservacao;
import br.facens.pa5_ib.repository.EstadoConservacaoRepository;

@Service
public class EstadoConservacaoService
{

    @Autowired
    private EstadoConservacaoRepository ecr;

    public List<EstadoConservacao> getEstadoDeConservacao(){
        if(ecr.count() == 0){
            ecr.save(new EstadoConservacao("Extinta"));
            ecr.save(new EstadoConservacao("Extinta na natureza"));
            ecr.save(new EstadoConservacao("Criticamente em perigo"));
            ecr.save(new EstadoConservacao("Em perigo"));
            ecr.save(new EstadoConservacao("Vulnerável"));
            ecr.save(new EstadoConservacao("Quase ameaçada"));
            ecr.save(new EstadoConservacao("Pouco preocupante"));
        }
        return ecr.findAll();
    }


    public EstadoConservacao getReinoById(Integer id) {
        return ecr.findById(id).get();
    }
}