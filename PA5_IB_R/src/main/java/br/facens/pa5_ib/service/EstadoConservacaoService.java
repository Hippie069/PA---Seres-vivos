package br.facens.pa5_ib.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.model.EstadoConservacao;
import br.facens.pa5_ib.repository.EstadoConservacaoRepository;

@Service
public class EstadoConservacaoService
{

    @Autowired
    private EstadoConservacaoRepository ecr;

    public EstadoConservacao getEstadoConservacaoById(Integer id){
        return ecr.getEstadoConservacaoById(id);
    }

    public ArrayList<EstadoConservacao> getEstadosConversavacao()
    {
        HashMap<Integer, EstadoConservacao> estadosConservacao = ecr.getEstadoConservacaos();
        ArrayList<EstadoConservacao> ecRetornados = new ArrayList<EstadoConservacao>();

        for(EstadoConservacao e:estadosConservacao.values())
        {
            ecRetornados.add(e);
        }//for

        return ecRetornados;
    }

}