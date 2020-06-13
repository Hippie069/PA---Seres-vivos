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

    public double calcIndiceShannon(int codigo){

        double ni;//nesse exemplo, será considerado que cada espécie tem o msm número de individuos
        int S;//numero de espécies
        double N;//Numero total de individuos
        double Pi;
        double H = 0.0;

        cr.findById(codigo).get().setiShannon(H);

        N = cr.findById(codigo).get().getDimensaoEspaco();
        S = cr.findById(codigo).get().getSerVivo().size();

        ni = N/S;//Definição de quantos individuos há por espécie

        Pi = ni/N;

        H = - Pi * Math.log(Pi);

        return H;
    }


}