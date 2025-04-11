package org.example;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private String matricula;
    private Plano plano;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (!matricula.trim().isEmpty()){
        this.matricula = matricula;}
        else {
            throw new IllegalArgumentException("matrícula inválida!");
        }
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    public String GetTipoUltimoPagamento(){
       return plano.GetTipoUltimoPagamento();
    }
    public float GetValorAPagar(){
        return plano.ValorAPagar();
    }
    public int QuantidadeDeSessoesParticularComPersonal(){
    return plano.QuantidadeDeSessoesParticularComPersonal();
    }
    public float ValorTotalGastoSessaoParticularComPersonal(){
        return plano.ValorTotalGastoSessaoParticularComPersonal();
    }
    public String NomeInstrutorDaUltimaSessaoParticularComPersonal(){
        return plano.GetNomeInstrutorUltimaSessaoParticularComPersonal();
    }

    public Aluno(String nome, int idade, Plano plano){
        super(nome, idade);
        this.plano = plano;
    }
}
