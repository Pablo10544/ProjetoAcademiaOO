package org.example;

import java.time.LocalDate;

public class AvaliacaoFisica {
    private LocalDate data;
    private Aluno aluno;
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public AvaliacaoFisica(LocalDate data,Aluno aluno){
        this.aluno = aluno;
        this.data = data;
    }
    public String GetEnderecoAvaliacaoFisica(){
        return endereco.GetEnderecoCompleto();
    }
}
