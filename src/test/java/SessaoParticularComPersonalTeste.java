import org.example.Instrutor;
import org.example.SessaoParticularComPersonal;
import org.example.TipoContratacao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class SessaoParticularComPersonalTeste {
    @Test
    public void setValor(){

        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        assertEquals(sessao.getValor(),100);
    }
    @Test
    public void setValorInvalido(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(-1f,1,instrutor);});
        assertEquals(ex.getMessage(),"valor negativo!");
    }
    @Test
    public void setQuantidade(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        assertEquals(sessao.getQuantidade(),1);
    }
    @Test
    public void setQuantidadeInvalido(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,0,instrutor);});
        assertEquals(ex.getMessage(),"quantidade menor igual a zero!");
    }
    @Test
    public void TipoContratacaoInstrutor(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        assertEquals(sessao.TipoContratacaoInstrutor(),"clt");
    }
    @Test
    public void GetNomeInstrutor(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        assertEquals(sessao.getNomeInstrutor(),"Joao");
    }
}
