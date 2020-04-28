package br.facens.pa5_ib.repository;


import br.facens.pa5_ib.model.SerVivo;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class SerVivoRepository {
    ArrayList<SerVivo> seresvivos;
    int contador=0;

    public SerVivoRepository ()
    {
       seresvivos = new ArrayList<>();
    }

    public void addSerVivo(SerVivo servivo, String reino, String EC)
    {
        servivo.setIdSerVivo(contador+1);
        servivo.setReino(reino);
        servivo.setEstadoConservacao(EC);
        seresvivos.add(servivo);
        contador++;
    }

    public ArrayList<SerVivo> getSerVivo(){
        return this.seresvivos;
    }
}