package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Manutencao {
    private LocalDate data;
    private float custo;
    private Tecnico tecnico;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        if(custo<0){
            throw new IllegalArgumentException("Custo negativo!");
        }else{

        this.custo = custo;
    }}

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public String GetCargoTecnico(){
        return tecnico.GetCargoContratado();
    }
    public Manutencao(LocalDate data, float custo, Tecnico tecnico) {
        setData(data);
        setCusto(custo);
        setTecnico(tecnico);
    }
}
