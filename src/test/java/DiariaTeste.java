import org.example.Diaria;
import org.example.Instrutor;
import org.example.SessaoParticularComPersonal;
import org.example.TipoContratacao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariaTeste {
    @Test
    public void setDias() {
        Diaria diaria = new Diaria(10,10);
        assertEquals(diaria.getDias(),10);
    }
    @Test
    public void setDiasInvalido() {
        Exception ex=assertThrows(IllegalArgumentException.class,()->{Diaria diaria = new Diaria(-1,10);});
        assertEquals(ex.getMessage(),"Dias deve ser maior ou igual a zero!");

    }
    @Test
    public void setValorDiaria() {
        Diaria diaria = new Diaria(10,15);
        assertEquals(diaria.getValorDiaria(),15);
    }
    @Test
    public void setValorDiariaInvalido() {
        Exception ex=assertThrows(IllegalArgumentException.class,()->{ Diaria diaria = new Diaria(10,-1);});
        assertEquals(ex.getMessage(),"Valor diaria deve ser maior ou igual a zero!");
    }
    @Test
    public void ValorAPagar(){
        Diaria diaria = new Diaria(10,15);
        assertEquals(diaria.ValorAPagar(),150);
    }
    @Test
    public void setDuracaoMeses(){
        Diaria diaria = new Diaria(10,15);
        diaria.setDuracaoMeses(5);
        assertEquals(diaria.getDuracaoMeses(),5);
    }
    @Test
    public void setDuracaoMesesInvalido(){
        Diaria diaria = new Diaria(10,15);
        Exception ex=assertThrows(IllegalArgumentException.class,()->{ diaria.setDuracaoMeses(0);});
        assertEquals(ex.getMessage(),"Duração menor igual a zero!");
    }
    @Test
    public void QuantidadeDeSessoesParticularComPersonal(){
        Diaria diaria = new Diaria(10,15);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor);
        diaria.addSessoes(s);
        diaria.addSessoes(s2);
        assertEquals(diaria.QuantidadeDeSessoesParticularComPersonal(),4);
    }
    @Test
    public void ValorTotalGastoSessaoParticularComPersonal(){
        Diaria diaria = new Diaria(10,15);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor);
        diaria.addSessoes(s);
        diaria.addSessoes(s2);
        assertEquals(diaria.ValorTotalGastoSessaoParticularComPersonal(),40);
    }
    @Test
    public void GetNomeInstrutorUltimaSessaoParticularComPersonal(){
        Diaria diaria = new Diaria(10,15);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Instrutor instrutor2 = new Instrutor(1000f,tipo,"Joana",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor2);
        diaria.addSessoes(s);
        diaria.addSessoes(s2);
        assertEquals(diaria.GetNomeInstrutorUltimaSessaoParticularComPersonal(),"Joana");
    }
}
