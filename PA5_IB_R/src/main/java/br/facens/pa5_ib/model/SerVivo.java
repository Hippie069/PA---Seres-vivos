package br.facens.pa5_ib.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SerVivo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idSerVivo;
    private String nomeSerVivo;
    private String especie;

    @ManyToOne
    @JoinColumn(name="ID_ECSER")
    private EstadoConservacao estadoConservacao;
    
    @ManyToOne
    @JoinColumn(name="ID_REINOSER")
    private Reino reino;

    @OneToMany
    @JoinColumn(name="ID_PARSER")
    private List<Participa> participa;

    @OneToMany
    @JoinColumn(name="ID_COM")
    private List<Comunidade> comunidade;

    

    public int getIdSerVivo() {
        return idSerVivo;
    }

    public void setIdSerVivo(int idSerVivo) {
        this.idSerVivo = idSerVivo;
    }

    public String getNomeSerVivo() {
        return nomeSerVivo;
    }

    public void setNomeSerVivo(String nomeSerVivo) {
        this.nomeSerVivo = nomeSerVivo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public Reino getReino() {
        return reino;
    }

    public void setReino(Reino reino) {
        this.reino = reino;
    }

    public List<Comunidade> getComunidade() {
        return comunidade;
    }

    public void setComunidade(List<Comunidade> IDComunidade) {
        this.comunidade = IDComunidade;
    }

   
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((especie == null) ? 0 : especie.hashCode());
        result = prime * result + ((comunidade == null) ? 0 : comunidade.hashCode());
        result = prime * result + ((reino == null) ? 0 : reino.hashCode());
        result = prime * result + idSerVivo;
        result = prime * result + ((estadoConservacao == null) ? 0 : estadoConservacao.hashCode());
        result = prime * result + ((nomeSerVivo == null) ? 0 : nomeSerVivo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SerVivo other = (SerVivo) obj;
        if (especie == null) {
            if (other.especie != null)
                return false;
        } else if (!especie.equals(other.especie))
            return false;
        if (comunidade == null) {
            if (other.comunidade != null)
                return false;
        } else if (!comunidade.equals(other.comunidade))
            return false;
        if (reino == null) {
            if (other.reino != null)
                return false;
        } else if (!reino.equals(other.reino))
            return false;
        if (idSerVivo != other.idSerVivo)
            return false;
        if (estadoConservacao == null) {
            if (other.estadoConservacao != null)
                return false;
        } else if (!estadoConservacao.equals(other.estadoConservacao))
            return false;
        if (nomeSerVivo == null) {
            if (other.nomeSerVivo != null)
                return false;
        } else if (!nomeSerVivo.equals(other.nomeSerVivo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SerVivo{" + "IDSerVivo=" + idSerVivo + ", nomeSerVivo=" + nomeSerVivo + 
        ", Especie=" + especie + ", EstadoConservacao=" + estadoConservacao + 
        ", IDReino=" + reino.getNomeReino() + ", IDComunidade=" + comunidade + '}';
    }

    public List<Participa> getParticipa() {
        return participa;
    }

    public void setParticipa(List<Participa> participa) {
        this.participa = participa;
    }
}