package br.facens.pa5_ib.model;

import java.util.ArrayList;

import javax.persistence.OneToMany;

public class SerVivo {
    private int idSerVivo;
    private String nomeSerVivo;
    private String especie;
    private String estadoConservacao;
    private String reino;

    @OneToMany
    private ArrayList<Comunidade> comunidade;

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

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public ArrayList<Comunidade> getComunidade() {
        return comunidade;
    }

    public void setComunidade(ArrayList<Comunidade> IDComunidade) {
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
        ", IDReino=" + reino + ", IDComunidade=" + comunidade + '}';
    }
}