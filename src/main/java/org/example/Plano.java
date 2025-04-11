package org.example;

import java.util.ArrayList;

public abstract class Plano {
    protected int duracaoMeses;
    protected ArrayList<SessaoParticularComPersonal> sessoes;
    private ArrayList<FormaDePagamento> formaDePagamento;

    public ArrayList<SessaoParticularComPersonal> getSessoes() {
        return sessoes;
    }
    public String GetTipoUltimoPagamento(){
        FormaDePagamento ultimoPagamento = formaDePagamento.get(formaDePagamento.size()-1);
        return ultimoPagamento.getTipo();
    }
    public void AddFormaDePagamento(FormaDePagamento forma) {
        formaDePagamento.add(forma);
    }
    public void setSessoes(ArrayList<SessaoParticularComPersonal> sessoes) {
        this.sessoes = sessoes;
    }

    public ArrayList<FormaDePagamento> getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(ArrayList<FormaDePagamento> formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }
    public void addSessoes(SessaoParticularComPersonal sessao) {
        sessoes.add(sessao);

    }
    public void setDuracaoMeses(int duracaoMeses) {
        if(duracaoMeses<=0){
            throw new IllegalArgumentException("Duração menor igual a zero!");
    }else{
            this.duracaoMeses = duracaoMeses;
        }
    }
    public int QuantidadeDeSessoesParticularComPersonal(){
        int quantidade=0;
        for (SessaoParticularComPersonal s : sessoes) {
            quantidade += s.getQuantidade();
        }
        return quantidade;
    }
    public float ValorTotalGastoSessaoParticularComPersonal(){
        float valorTotalGasto=0;
        for (SessaoParticularComPersonal s : sessoes) {
            valorTotalGasto += s.getValor() * s.getQuantidade();
        }
        return valorTotalGasto;
    }
    public String GetNomeInstrutorUltimaSessaoParticularComPersonal(){
        return sessoes.get(sessoes.size()-1).getNomeInstrutor();
    }
    public abstract float ValorAPagar();
    public Plano(){
        sessoes = new ArrayList<>();
        formaDePagamento = new ArrayList<>();

    }
}

