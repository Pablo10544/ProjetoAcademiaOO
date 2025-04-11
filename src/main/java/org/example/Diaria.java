package org.example;

public class Diaria extends Plano{
    private int dias;
    private float valorDiaria;

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        if(dias<0){
            throw new IllegalArgumentException("Dias deve ser maior ou igual a zero!");
        }else{
        this.dias = dias;
    }}

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        if(valorDiaria<0){
            throw new IllegalArgumentException("Valor diaria deve ser maior ou igual a zero!");
        }else{
        this.valorDiaria = valorDiaria;
    }}

    @Override
    public float ValorAPagar() {
        return dias*valorDiaria;
    }
    public Diaria(int dias, float valorDiaria) {
        setDias(dias);
        setValorDiaria(valorDiaria);
    }
}
