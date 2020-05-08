package br.facens.pa5_ib.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Participa {

    @Id
    private int idParticipa;
    private int qtdSeresVivos;

    @ManyToOne
    @JoinColumn(name="ID_PARSER")
    private SerVivo serVivo;

    @ManyToOne
    @JoinColumn(name="ID_PARCOM")
    private Comunidade comunidade;

    public int getIdParticipa() {
        return idParticipa;
    }

    public void setIdParticipa(int idParticipa) {
        this.idParticipa = idParticipa;
    }

    public int getQtdSeresVivos() {
        return qtdSeresVivos;
    }

    public void setQtdSeresVivos(int qtdSeresVivos) {
        this.qtdSeresVivos = qtdSeresVivos;
    }

    public SerVivo getSerVivo() {
        return serVivo;
    }

    public void setSerVivo(SerVivo serVivo) {
        this.serVivo = serVivo;
    }

    

}