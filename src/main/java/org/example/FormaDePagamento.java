package org.example;

import java.util.Date;

public class FormaDePagamento {
    private String Tipo;
    private String Status;
    private float Valor;
    private Date dataPagamento;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        if(tipo.toLowerCase()=="cartao"||tipo.toLowerCase()=="dinheiro"||tipo.toLowerCase()=="pix"){
            Tipo = tipo;
        }
        else{
            throw new IllegalArgumentException("Tipo da forma de pagamento inválido!");
        }
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        if(status.toLowerCase()=="pago"||status.toLowerCase()=="em processamento"||status.toLowerCase()=="aguardando pagamento"){
            Status = status;
        } else{
            throw new IllegalArgumentException("status inválido!");
        }
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        if(valor<0){
            throw new IllegalArgumentException("Valor negativo!");
        }else{
        Valor = valor;
    }}

    public Date getData() {
        return dataPagamento;
    }

    public void setData(Date data) {
        this.dataPagamento = data;
    }
    public FormaDePagamento(String tipo, String status, float valor) {
        setTipo(tipo);
        setStatus(status);
        setValor(valor);
    }
}
