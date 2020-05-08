package br.facens.pa5_ib.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class EstadoConservacao implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int idEstadoConservacao;
    String tipo;

    @OneToMany
    @JoinColumn(name="ID_ECSER")
    private List<SerVivo> servivo;

    public EstadoConservacao(String tipo){
        this.tipo = tipo;
    }

    public EstadoConservacao(){

    }

    public void setIdEstadoConservacao(int idEstadoConservacao) {
        this.idEstadoConservacao = idEstadoConservacao;
    }

    public int getIdEstadoConservacao() {
        return idEstadoConservacao;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idEstadoConservacao;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstadoConservacao other = (EstadoConservacao) obj;
        if (idEstadoConservacao != other.idEstadoConservacao)
            return false;
        
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[Id do Estado de Conservação: " + idEstadoConservacao + " Tipo: " + tipo + "]";
    }
}