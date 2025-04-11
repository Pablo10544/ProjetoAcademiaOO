package org.example;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected LocalDate dataNascimento;
    protected String sexo;
    protected Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()){
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("Nome vazio!");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade > 0){
            this.idade = idade;
        }else{
            throw new IllegalArgumentException("Idade menor igual a zero!");
        }
    }

    public LocalDate  getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento.isBefore(java.time.LocalDate.now())){
            this.dataNascimento = dataNascimento;
        }else{
            throw new IllegalArgumentException("Data de nascimento maior que data atual!");
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if(sexo != null && !sexo.isEmpty()){
            if(sexo.toLowerCase()=="homem" || sexo.toLowerCase()=="mulher")
            {
            this.sexo = sexo.toLowerCase();
            }
            else{
                throw new IllegalArgumentException("Sexo inválido!");
            }
        }else{
            throw new IllegalArgumentException("Sexo vazio!");
        }
    }
    public String GetEnderecoCompleto(){
        return endereco.GetEnderecoCompleto();
    }

    public Pessoa(String nome, int idade){
        //Foram usadas os sets para que as validações acontecam também no construtor
        setNome(nome);
        setIdade(idade);
    }
}
