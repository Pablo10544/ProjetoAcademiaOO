import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstrutorTeste {
    @Test
    public void SetAnosExperiencia(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        instrutor.setAnosDeExperiencia(2);
        assertEquals(instrutor.getAnosDeExperiencia(),2);
    }
    @Test
    public void SetAnosExperienciaInvalido(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
       Exception ex = assertThrows(IllegalArgumentException.class,()->{ instrutor.setAnosDeExperiencia(-1);});
       assertEquals(ex.getMessage(),"Anos de experiência negativo!");
    }
    @Test
    public void EnderecoDaUltimaAvaliacaoFisica(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        AvaliacaoFisica aval = new AvaliacaoFisica(LocalDate.now(),aluno);
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        aval.setEndereco(endereco);
        instrutor.AddAvaliacaoFisica(aval);
       assertEquals(instrutor.EnderecoDaUltimaAvaliacaoFisica(),endereco.GetEnderecoCompleto());
    }
}
