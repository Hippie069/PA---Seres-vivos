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
public class Reino implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idReino;
    private String nomeReino;

    @OneToMany
    @JoinColumn(name="ID_REINOSER")
    private List<SerVivo> serVivo;
    
    public Reino(String nomeReino) {
        this.nomeReino = nomeReino;
    }

    public Reino(){

    }
    
    public int getIdReino() {
        return idReino;
    }

    public void setIdReino(int idReino) {
        this.idReino = idReino;
    }

    public String getNomeReino() {
        return nomeReino;
    }

    public void setNomeReino(String nomeReino) {
        this.nomeReino = nomeReino;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idReino;
        result = prime * result + ((nomeReino == null) ? 0 : nomeReino.hashCode());
        result = prime * result + ((serVivo == null) ? 0 : serVivo.hashCode());
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
        Reino other = (Reino) obj;
        if (idReino != other.idReino)
            return false;
        if (nomeReino == null) {
            if (other.nomeReino != null)
                return false;
        } else if (!nomeReino.equals(other.nomeReino))
            return false;
        if (serVivo == null) {
            if (other.serVivo != null)
                return false;
        } else if (!serVivo.equals(other.serVivo))
            return false;
        return true;
    }

    
 
}
