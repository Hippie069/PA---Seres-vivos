package br.facens.pa5_ib.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; 
import javax.persistence.UniqueConstraint;

@Entity
public class Comunidade implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idComunidade;
    private String nomeComunidade;
    private double dimensaoEspaco;

    @ManyToMany
    @JoinTable(
        name="Comunidade_Animal",
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_comunidade", "id_servivo" }),
        joinColumns        = @JoinColumn(name = "id_comunidade" ),
        inverseJoinColumns = @JoinColumn(name = "id_servivo")
    )
    private List<SerVivo> serVivo;

    public int getIdComunidade() {
        return idComunidade;
    }

    public void setIdComunidade(int idComunidade) {
        this.idComunidade = idComunidade;
    }

    public String getNomeComunidade() {
        return nomeComunidade;
    }

    public void setNomeComunidade(String nomeComunidade) {
        this.nomeComunidade = nomeComunidade;
    }

    public double getDimensaoEspaco() {
        return dimensaoEspaco;
    }

    public void setDimensaoEspaco(double dimensaoEspaco) {
        this.dimensaoEspaco = dimensaoEspaco;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(dimensaoEspaco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + idComunidade;
        result = prime * result + ((nomeComunidade == null) ? 0 : nomeComunidade.hashCode());
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
        Comunidade other = (Comunidade) obj;
        if (Double.doubleToLongBits(dimensaoEspaco) != Double.doubleToLongBits(other.dimensaoEspaco))
            return false;
        if (idComunidade != other.idComunidade)
            return false;
        if (nomeComunidade == null) {
            if (other.nomeComunidade != null)
                return false;
        } else if (!nomeComunidade.equals(other.nomeComunidade))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Comunidade [dimensaoEspaco=" + dimensaoEspaco + ", idComunidade=" + idComunidade + ", nomeComunidade="
                + nomeComunidade + "]";
    }

    public List<SerVivo> getSerVivo() {
        return serVivo;
    }

    public void setSerVivo(List<SerVivo> serVivo) {
        this.serVivo = serVivo;
    }
      
}