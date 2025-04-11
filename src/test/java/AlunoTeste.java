import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTeste {
    @Test
    public void setMatricula(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        aluno.setMatricula("202235022");
        assertEquals(aluno.getMatricula(),"202235022");
    }
    @Test
    public void setMatriculaInvalida(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
       Exception ex = assertThrows(IllegalArgumentException.class,()->{ aluno.setMatricula("");});
        assertEquals(ex.getMessage(),"matrícula inválida!");
    }
    @Test
    public void GetTipoUltimoPagamento(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        FormaDePagamento forma = new FormaDePagamento("pix","pago",10);
        FormaDePagamento forma2 = new FormaDePagamento("dinheiro","pago",10);
        valor.AddFormaDePagamento(forma);
        valor.AddFormaDePagamento(forma2);
        assertEquals(aluno.GetTipoUltimoPagamento(),forma2.getTipo());

    }
    @Test
    public void GetValorAPagar(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.GetValorAPagar(),100);
    }
    @Test
    public void QuantidadeDeSessoesParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",22);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        SessaoParticularComPersonal sessao2 = new SessaoParticularComPersonal(150f,1,instrutor);
        valor.addSessoes(sessao);
        valor.addSessoes(sessao2);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.QuantidadeDeSessoesParticularComPersonal(),2);
    }
    @Test
    public void ValorTotalGastoSessaoParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",22);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        SessaoParticularComPersonal sessao2 = new SessaoParticularComPersonal(150f,1,instrutor);
        valor.addSessoes(sessao);
        valor.addSessoes(sessao2);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.ValorTotalGastoSessaoParticularComPersonal(),250);
    }
    @Test
    public void NomeInstrutorDaUltimaSessaoParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Instrutor instrutor2 = new Instrutor(1000f,tipo,"Joana",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor2);
        valor.addSessoes(s);
        valor.addSessoes(s2);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.NomeInstrutorDaUltimaSessaoParticularComPersonal(),"Joana");
    }


    @Test
    public void SetNome(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.getNome(),"Joao");

    }
    @Test
    public void SetNomeInvalido(){
        ValorFixo valor = new ValorFixo(100);
       Exception ex = assertThrows(IllegalArgumentException.class, ()->{ Aluno aluno = new Aluno("",20,valor);});
       assertEquals(ex.getMessage(),"Nome vazio!");
    }
    @Test
    public void SetIdade(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(aluno.getIdade(),20);
    }
    @Test
    public void SetIdadeInvalido(){
        ValorFixo valor = new ValorFixo(100);
        Exception ex = assertThrows(IllegalArgumentException.class, ()->{ Aluno aluno = new Aluno("Joao",0,valor);});
        assertEquals(ex.getMessage(),"Idade menor igual a zero!");
    }
    @Test
    public void SetDataNascimento(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        aluno.setDataNascimento(LocalDate.now().minusMonths(2));
        assertEquals(aluno.getDataNascimento(),LocalDate.now().minusMonths(2));
    }
    @Test
    public void SetDataNascimentoInvalida(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        Exception ex = assertThrows(IllegalArgumentException.class, ()->{aluno.setDataNascimento(LocalDate.now().plusMonths(2));});
        assertEquals(ex.getMessage(),"Data de nascimento maior que data atual!");
    }
    @Test
    public void setSexoHomem(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        aluno.setSexo("homem");
    }
    @Test
    public void setSexoMulher(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joana",20,valor);
        aluno.setSexo("mulher");
    }
    @Test
    public void setSexoInvalido(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joana",20,valor);
      Exception ex = assertThrows(IllegalArgumentException.class,()->{  aluno.setSexo("alkda");});
      assertEquals(ex.getMessage(),"Sexo inválido!");
    }
    @Test
    public void setSexoVazio(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joana",20,valor);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ aluno.setSexo("");});
        assertEquals(ex.getMessage(),"Sexo vazio!");
    }
    @Test
    public void GetEnderecoCompleto(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joana",20,valor);
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        aluno.setEndereco(endereco);
        assertEquals(aluno.GetEnderecoCompleto(),"RJ, Petrópolis, Rua da Imperatriz, Centro");
    }
}
