package br.facens.pa5_ib.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import br.facens.pa5_ib.model.Comunidade;

@Repository
public class ComunidadeRepository {
    ArrayList<Comunidade> comunidades;
    int contador=0;

    public ComunidadeRepository ()
    {
       comunidades = new ArrayList<>();
    }

    public void addComunidades(Comunidade comunidade)
    {
        comunidade.setIdComunidade(contador + 1);
        comunidades.add(comunidade);
        contador++;
    }

    public ArrayList<Comunidade> getComunidades(){
        return this.comunidades;
    }
}