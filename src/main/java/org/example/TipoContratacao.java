package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TipoContratacao {
    private String tipo;
    private LocalDate inicioContratacao;
    private String cargo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(tipo.toLowerCase()=="clt"|| tipo.toLowerCase()=="pj"){
        this.tipo = tipo.toLowerCase();}
        else{
            throw new IllegalArgumentException("tipo inválido");
        }
    }

    public LocalDate getInicioContratacao() {
        return inicioContratacao;
    }

    public void setInicioContratacao(LocalDate inicioContratacao) {
        this.inicioContratacao = inicioContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(cargo.toLowerCase()=="estagiario" || cargo.toLowerCase()=="junior"||cargo.toLowerCase() =="pleno"|| cargo.toLowerCase() =="senior"){
        this.cargo = cargo.toLowerCase();
        }else{
            throw new IllegalArgumentException("Cargo inválido");
        }
    }
    public Boolean EClt(){
        if(tipo=="clt"){
            return true;
        }
        return false;
    }
    public Boolean ESenior(){
        if(cargo=="senior"){
            return true;
        }
        return false;
    }
    public Boolean EJunior(){
        if(cargo=="junior"){
            return true;
        }
        return false;
    }
    public int CalcularTempoContratacaoMeses() {
        return (int) ChronoUnit.MONTHS.between(inicioContratacao, LocalDate.now());
    }
    public TipoContratacao(String tipo, LocalDate contratacao) {
    setTipo(tipo);
    setInicioContratacao(contratacao);
    }
}
