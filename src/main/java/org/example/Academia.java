package org.example;

import java.util.ArrayList;

public class Academia {
    private String nome;
    private int capacidadePessoas;
    private int capacidadeEquipamentos;
    private ArrayList<Equipamento> equipamentos;
    private Equipe equipe;
    private ArrayList<Evento> eventos;
    private Endereco endereco;
    private ArrayList<Aluno> alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome!=""){
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("Nome vazio!");
        }
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public void setCapacidadePessoas(int capacidadePessoas) {
        if(capacidadePessoas>0){
            this.capacidadePessoas = capacidadePessoas;
        }else{
        throw new IllegalArgumentException("Capacidade Pessoas menor igual a zero!");
        }

    }

    public int getCapacidadeEquipamentos() {
        return capacidadeEquipamentos;
    }

    public void setCapacidadeEquipamentos(int capacidadeEquipamentos) {
        if(capacidadeEquipamentos<=0){
            throw new IllegalArgumentException("Capacidade Equipamentos menor igual a zero!");
        }else{
            this.capacidadeEquipamentos = capacidadeEquipamentos;
        }

    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public void AddAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    public int IdadeInstrutorEvento(Evento evento){
        return evento.GetIdadeInstrutor();
    }
    public float GetValorPagarAluno(Aluno aluno){
      return  aluno.GetValorAPagar();
    }
    public Boolean PessoaEUmTecnicoCLT(Pessoa pessoa){
       return equipe.ETecnico(pessoa);
    }
    public String NomeDoTecnicoQueConsertouMaisEquipamentos(){
        return equipe.nomeTecnicoConsertouMaisEquipamentos();
    }
    public String NomeDoAlunoQueMaisGastouComSessoesParticulares(){
        float valorGasto=0;
        String nome ="";
        for (Aluno a:alunos){
            if(a.ValorTotalGastoSessaoParticularComPersonal()>valorGasto){
                valorGasto = a.ValorTotalGastoSessaoParticularComPersonal();
                nome = a.getNome();
            }
        }
        return nome;
    }
    public ArrayList<String> NomesFuncionariosSeniors(){
        return equipe.NomesDosFuncionariosSeniors();
    }
    public ArrayList<String> NomesFuncionariosCLTs(){
        return equipe.NomesDosFuncionariosClts();
    }
    public ArrayList<String> NomeFuncionariosJuniors(){
        return equipe.NomeDosFuncionariosJuniors();
    }
    public Academia(String nome, int capacidadePessoas, int capacidadeEquipamentos,Equipe equipe){
    setEquipe(equipe);
    setCapacidadePessoas(capacidadePessoas);
    setCapacidadeEquipamentos(capacidadeEquipamentos);
    setNome(nome);
    alunos = new ArrayList<>();
    eventos = new ArrayList<>();
    equipamentos = new ArrayList<>();
    }
}
