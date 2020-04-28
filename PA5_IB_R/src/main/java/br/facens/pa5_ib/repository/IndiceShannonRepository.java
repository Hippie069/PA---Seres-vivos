package br.facens.pa5_ib.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;



@Repository
public class IndiceShannonRepository {
ArrayList<Double> Is;

    public IndiceShannonRepository(){
        Is = new ArrayList<>();
    }

    public ArrayList<Double> getIndices(){
        return this.Is;
    }

    public ArrayList<Double> getIs()
    {
        return Is;
    }

}