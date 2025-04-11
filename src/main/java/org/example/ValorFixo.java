package org.example;

public class ValorFixo extends Plano{
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if(valor<0){
            throw new IllegalArgumentException("Valor negativo");
        }
        this.valor = valor;
    }

    @Override
    public float ValorAPagar() {
        return valor;
    }
    public ValorFixo(float valor){
        setValor(valor);
    }
}
