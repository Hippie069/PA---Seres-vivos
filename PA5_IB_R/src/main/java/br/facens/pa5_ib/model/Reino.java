package br.facens.pa5_ib.model;

public class Reino {
    private int idReino;
    private String nomeReino;
    
    public Reino(int idReino, String nomeReino) {
        this.idReino = idReino;
        this.nomeReino = nomeReino;
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

    
 
}
