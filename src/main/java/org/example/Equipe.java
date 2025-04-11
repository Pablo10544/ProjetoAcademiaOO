package org.example;

import java.util.ArrayList;

public class Equipe {
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Instrutor> instrutores;

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(ArrayList<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public ArrayList<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(ArrayList<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }
    public Equipe(ArrayList<Tecnico> tecnicos, ArrayList<Instrutor> instrutores) {
        this.tecnicos = tecnicos;
        this.instrutores = instrutores;
    }
    public String GetEnderecoCompletoInstrutor(Instrutor instrutor) {
       return instrutor.GetEnderecoCompleto();
    }
    public String GetEnderecoCompletoTecnico(Tecnico tecnico){
        return tecnico.GetEnderecoCompleto();

    }
    public String GetTipoEquipamentoTecnicoFazManutencao(Tecnico tecnico){
        return tecnico.GetTipoEquipamentoManutencoes();
    }
    public String GetTipoContratacaoTecnico(Tecnico tecnico) {
        return tecnico.GetTipoContratacaoFuncionario();
    }
    public Boolean ETecnico(Pessoa pessoa){
        if(tecnicos.contains(pessoa)){
           return tecnicos.get(tecnicos.indexOf(pessoa)).EClt();
        }
        return false;
    }
    public String nomeTecnicoConsertouMaisEquipamentos(){
        int quantidade = 0;
        String nome="";
        for (Tecnico t : tecnicos) {
            if (t.tamanhoManutencoes()>quantidade){
                quantidade = t.tamanhoManutencoes();
                nome = t.getNome();
            }
        }
        return nome;
    }
    public ArrayList<String> NomesDosFuncionariosSeniors(){
    ArrayList<String> nomes = new ArrayList<>();
    for (Tecnico t : tecnicos) {
        if(t.ESenior()){
            nomes.add(t.getNome());
        }
    }
    for (Instrutor instrutor : instrutores) {
        if(instrutor.ESenior()){
            nomes.add(instrutor.getNome());
        }
    }
    return nomes;
    }
    public ArrayList<String> NomeDosFuncionariosJuniors(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Tecnico t : tecnicos) {
            if(t.EJunior()){
                nomes.add(t.getNome());
            }
        }
        for (Instrutor instrutor : instrutores) {
            if(instrutor.EJunior()){
                nomes.add(instrutor.getNome());
            }
        }
        return nomes;
    }
    public ArrayList<String> NomesDosFuncionariosClts(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Tecnico t : tecnicos) {
            if(t.EClt()){
                nomes.add(t.getNome());
            }
        }
        for (Instrutor instrutor : instrutores) {
            if(instrutor.ESenior()){
                nomes.add(instrutor.getNome());
            }
        }
        return nomes;
    }
}
