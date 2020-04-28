package br.facens.pa5_ib.repository;


import java.util.HashMap;

import org.springframework.stereotype.Repository;

import br.facens.pa5_ib.model.EstadoConservacao;

@Repository
public class EstadoConservacaoRepository {
    HashMap<Integer, EstadoConservacao> ec = new HashMap<>();


    public EstadoConservacaoRepository(){
        ec.put(1, new EstadoConservacao(1, "Extinta"));
        ec.put(2, new EstadoConservacao(2, "Extinta na natureza"));
        ec.put(3, new EstadoConservacao(3, "Criticamente em perigo"));
        ec.put(4, new EstadoConservacao(4, "Em perigo"));
        ec.put(5, new EstadoConservacao(5, "Vulnerável"));
        ec.put(6, new EstadoConservacao(6, "Quase ameaçada"));
        ec.put(7, new EstadoConservacao(7, "Pouco preocupante"));
    }//Optei por mudar para hashMap, por isso houveram algumas mudanças neste repositório


    public HashMap<Integer, EstadoConservacao> getEstadoConservacaos(){
        return this.ec;
    }

	public EstadoConservacao getEstadoConservacaoById(Integer id) {
		return ec.get(id);
	}


}