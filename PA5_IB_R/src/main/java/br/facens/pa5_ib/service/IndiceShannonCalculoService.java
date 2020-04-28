package br.facens.pa5_ib.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.pa5_ib.repository.ComunidadeRepository;
import br.facens.pa5_ib.repository.IndiceShannonRepository;
import br.facens.pa5_ib.repository.SerVivoRepository;

@Service
public class IndiceShannonCalculoService {

    @Autowired
    private SerVivoRepository svr;
    @Autowired
    private ComunidadeRepository cr;
    @Autowired
    private IndiceShannonRepository isr;

    public void addIndice(Double indice)
    {
        isr.getIs().add(indice);
    }

    public Integer contabilizarEspecies()//Função que contabilizará quantas especies há
    {

        if(svr.getSerVivo().size() <= 0 || svr.getSerVivo().isEmpty())
            return 0;
        else
            return svr.getSerVivo().size();//Assumindo que cada ser vivo tem uma espécie propria cadastrada, Sendo assim, S = n de especies cadastradas    
    }

    public Integer contabilizarDimensaoEspaco(Integer i)//Funão que ditará quantos individuos tem por especie, considerando que a cada m² existira um individuo 
    {

            Integer d = 0;

            if(!(cr.getComunidades().isEmpty()))
            {
                d = (int) cr.getComunidades().get(i).getDimensaoEspaco();
                return d;
            }else
            {
                return  0;
            }

    }

    public Integer contabilizarTotalIndividuos()
    {
        Integer i = 0, N = 0;
        

        do {
            N = contabilizarDimensaoEspaco(i);
            i++;
        } while (i <= contabilizarEspecies());

        return N;
    }

    public ArrayList<Double> getTodosIndices()
    {
        if(isr.getIs().isEmpty())
            return null;

        return isr.getIs();
    }


}