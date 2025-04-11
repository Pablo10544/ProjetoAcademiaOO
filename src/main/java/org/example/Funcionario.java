package org.example;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private float Salario;
    private TipoContratacao TipoContratacao;

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) {
        if(salario>=0){
        Salario = salario;}
        else{
            throw new IllegalArgumentException("Salario negativo");
        }
    }

    public org.example.TipoContratacao getTipoContratacao() {
        return TipoContratacao;
    }

    public void setTipoContratacao(org.example.TipoContratacao tipoContratacao) {
        TipoContratacao = tipoContratacao;
    }
    public String GetTipoContratacaoFuncionario(){
        return TipoContratacao.getTipo();
    }
    public String GetCargoContratado(){
        return TipoContratacao.getCargo();
    }
    public LocalDate GetDataContratacao(){
        return TipoContratacao.getInicioContratacao();
    }
    public Boolean EClt(){
        return TipoContratacao.EClt();
    }
    public Boolean ESenior(){
        return TipoContratacao.ESenior();
    }
    public Boolean EJunior(){
        return TipoContratacao.EJunior();
    }
    public Funcionario(float salario, TipoContratacao tipoContratacao,String nome, int idade) {
        super(nome, idade);
        setSalario(salario);// foi usado o setSalario para ter as validações no construtor
        this.TipoContratacao = tipoContratacao;
    }
}
