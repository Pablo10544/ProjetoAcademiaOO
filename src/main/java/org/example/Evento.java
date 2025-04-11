package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Evento {
    private LocalDate Data;
    private int capacidade;
    private String Descricao;
    private String nome;
    private Endereco Endereco;
    private ArrayList<Aluno> participante;
    private Instrutor instrutor;

    public org.example.Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(org.example.Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        Data = data;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return Descricao;
    }
    public void AddParticipante(Aluno aluno){
        participante.add(aluno);
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public org.example.Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(org.example.Endereco endereco) {
        Endereco = endereco;
    }

    public ArrayList<Aluno> getParticipante() {
        return participante;
    }

    public void setParticipante(ArrayList<Aluno> participante) {
        this.participante = participante;
    }
    public LocalDate DataContratacaoInstrutor(){
        return instrutor.GetDataContratacao();
    }
    public String GetTipoPagamentoParticipanteEvento(Aluno aluno){
        return aluno.GetTipoUltimoPagamento();
    }
    public int GetIdadeInstrutor(){
        return instrutor.getIdade();
    }
    public String GetEnderecoDaUltimaAvaliacaoFisicaInstrutor(){
        return instrutor.EnderecoDaUltimaAvaliacaoFisica();
    }
    public Evento(LocalDate data, int capacidade, String nome,Instrutor instrutor) {
        setData(data);
        setCapacidade(capacidade);
        setNome(nome);
        setInstrutor(instrutor);
        participante = new ArrayList<>();
    }
}
