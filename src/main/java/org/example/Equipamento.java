package org.example;

import java.util.ArrayList;

public class Equipamento {
    private String nome;
    private String status;
    private ArrayList<Manutencao> manutencoes;
    private TipoEquipamento tipoEquipamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty()){
        this.nome = nome;}
        else{
            throw new IllegalArgumentException("Nome vazio!");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(status.toLowerCase()=="funcionando"||status.toLowerCase()=="em manutencao"){
        this.status = status.toLowerCase();}
        else{
            throw new IllegalArgumentException("Status inválido!");
        }
    }

    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(ArrayList<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }
    public String GetCargoTecnico(Manutencao manutencao){
        return manutencao.GetCargoTecnico();
    }
    public Equipamento(String nome, String status,TipoEquipamento tipoEquipamento) {
        setNome(nome);
        setStatus(status);
        this.tipoEquipamento = tipoEquipamento;
        manutencoes = new ArrayList<>();
    }
}
