import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValorFixoTeste {
    @Test
    public void setValor() {
        ValorFixo valorFixo = new ValorFixo(100f);
        assertEquals(valorFixo.getValor(),100);
    }
    @Test
    public void setValorInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ValorFixo valorFixo = new ValorFixo(-1f);});
        assertEquals(ex.getMessage(),"Valor negativo");
    }
    @Test
    public void ValorAPagar(){
        ValorFixo valorFixo = new ValorFixo(100f);
        assertEquals(valorFixo.ValorAPagar(),100);
    }

    @Test
    public void setDuracaoMeses(){
        ValorFixo valor = new ValorFixo(100);
        valor.setDuracaoMeses(5);
        assertEquals(valor.getDuracaoMeses(),5);
    }
    @Test
    public void setDuracaoMesesInvalido(){
        ValorFixo valor = new ValorFixo(100);
        Exception ex=assertThrows(IllegalArgumentException.class,()->{ valor.setDuracaoMeses(0);});
        assertEquals(ex.getMessage(),"Duração menor igual a zero!");
    }
    @Test
    public void QuantidadeDeSessoesParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor);
        valor.addSessoes(s);
        valor.addSessoes(s2);
        assertEquals(valor.QuantidadeDeSessoesParticularComPersonal(),4);
    }
    @Test
    public void ValorTotalGastoSessaoParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor);
        valor.addSessoes(s);
        valor.addSessoes(s2);
        assertEquals(valor.ValorTotalGastoSessaoParticularComPersonal(),40);
    }
    @Test
    public void GetNomeInstrutorUltimaSessaoParticularComPersonal(){
        ValorFixo valor = new ValorFixo(100);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Instrutor instrutor2 = new Instrutor(1000f,tipo,"Joana",32);
        SessaoParticularComPersonal s = new SessaoParticularComPersonal(10f,1,instrutor);
        SessaoParticularComPersonal s2 = new SessaoParticularComPersonal(10f,3,instrutor2);
        valor.addSessoes(s);
        valor.addSessoes(s2);
        assertEquals(valor.GetNomeInstrutorUltimaSessaoParticularComPersonal(),"Joana");
    }
}
