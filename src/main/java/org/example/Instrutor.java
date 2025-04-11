package org.example;

import java.util.ArrayList;

public class Instrutor extends Funcionario {
    private int anosDeExperiencia;
    private ArrayList<AvaliacaoFisica> avaliacaoFisica;

    public ArrayList<AvaliacaoFisica> getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(ArrayList<AvaliacaoFisica> avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }
    public void AddAvaliacaoFisica(AvaliacaoFisica aval) {
        avaliacaoFisica.add(aval);
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        if (anosDeExperiencia < 0)
        {
            throw new IllegalArgumentException("Anos de experiência negativo!");
        }else{
        this.anosDeExperiencia = anosDeExperiencia;
    }}
    public String EnderecoDaUltimaAvaliacaoFisica(){
        return avaliacaoFisica.get(avaliacaoFisica.size()-1).GetEnderecoAvaliacaoFisica();
    }

    public Instrutor(Float salario, TipoContratacao tipoContratacao, String nome, int idade) {
        super(salario, tipoContratacao,nome,idade);
        avaliacaoFisica = new ArrayList<>();
    }
}
