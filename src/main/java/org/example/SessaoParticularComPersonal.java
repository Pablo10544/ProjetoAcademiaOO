package org.example;

public class SessaoParticularComPersonal {
    private Float valor;
    private int quantidade;
    private Instrutor instrutor;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        if(valor<0){
            throw new IllegalArgumentException("valor negativo!");
        }else{
        this.valor = valor;
    }}

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade<=0){
            throw new IllegalArgumentException("quantidade menor igual a zero!");
        }else{
            this.quantidade = quantidade;

        }
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }
    public String TipoContratacaoInstrutor(){
        return instrutor.GetTipoContratacaoFuncionario();
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
    public String getNomeInstrutor(){
        return instrutor.nome;
    }
    public SessaoParticularComPersonal(Float valor, int quantidade, Instrutor instrutor) {
        setValor( valor);
        setQuantidade(quantidade);
        this.instrutor = instrutor;

    }
}
