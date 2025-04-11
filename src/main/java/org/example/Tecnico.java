package org.example;

import java.util.ArrayList;

public class Tecnico extends Funcionario{
    private TipoEquipamento tipoEquipamentoQueMexe;
    private ArrayList<Manutencao> manutencoes;

    public ArrayList<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(ArrayList<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }
    public void AddManutencao(Manutencao manutencao){
        manutencoes.add(manutencao);
    }

    public TipoEquipamento getTipoEquipamentoQueMexe() {
        return tipoEquipamentoQueMexe;
    }

    public void setTipoEquipamentoQueMexe(TipoEquipamento tipoEquipamentoQueMexe) {
        this.tipoEquipamentoQueMexe = tipoEquipamentoQueMexe;
    }
    public int tamanhoManutencoes() {
        return manutencoes.size();
    }
    public String GetTipoEquipamentoManutencoes() {
        return tipoEquipamentoQueMexe.getTipo();
    }
    public Tecnico(float salario, TipoContratacao tipoContratacao, String nome, int idade,TipoEquipamento tipoEquipamentoQueMexe) {
        super(salario,tipoContratacao,nome,idade);
        this.tipoEquipamentoQueMexe = tipoEquipamentoQueMexe;
        manutencoes = new ArrayList<>();
    }
}
