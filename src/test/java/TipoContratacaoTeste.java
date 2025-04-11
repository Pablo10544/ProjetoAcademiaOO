import org.example.TipoContratacao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TipoContratacaoTeste {
    @Test
    public void SetTipoClt(){
        LocalDate date = LocalDate.now();
        TipoContratacao tipo = new TipoContratacao("clt",date);
        assertEquals(tipo.getTipo(),"clt");
    }
    @Test
    public void SetTipoPj(){
        LocalDate date = LocalDate.now();
        TipoContratacao tipo = new TipoContratacao("pj",date);
        assertEquals(tipo.getTipo(),"pj");
    }
    @Test
    public void SetTipoInvalido(){
        LocalDate date = LocalDate.now();
       Exception exception=assertThrows(IllegalArgumentException.class,()-> {TipoContratacao tipo = new TipoContratacao("aaaa",date);});
    assertEquals(exception.getMessage(),"tipo inválido");
    }
    @Test
    public void SetCargoEstagiario(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        tipo.setCargo("estagiario");
        assertEquals(tipo.getCargo(),"estagiario");
    }
    @Test
    public void SetCargoJunior(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        tipo.setCargo("junior");
        assertEquals(tipo.getCargo(),"junior");
    }
    @Test
    public void SetCargoPleno(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        tipo.setCargo("pleno");
        assertEquals(tipo.getCargo(),"pleno");
    }
    @Test
    public void SetCargoSenior(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        tipo.setCargo("senior");
        assertEquals(tipo.getCargo(),"senior");
    }
    @Test
    public void SetCargoInvalido(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        Exception exception=assertThrows(IllegalArgumentException.class,()-> {tipo.setCargo("aaaa");});
        assertEquals(exception.getMessage(),"Cargo inválido");
    }
    @Test
    public void EClt(){
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        assertEquals(tipo.EClt(),true);
    }
    @Test
    public void NaoEClt(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now());
        assertEquals(tipo.EClt(),false);
    }
    @Test
    public void EJunior(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now());
        tipo.setCargo("junior");
        assertEquals(tipo.EJunior(),true);
    }
    @Test
    public void NaoEJunior(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now());
        tipo.setCargo("senior");
        assertEquals(tipo.EJunior(),false);
    }
    @Test
    public void NaoESenior(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now());
        tipo.setCargo("junior");
        assertEquals(tipo.ESenior(),false);
    }
    @Test
    public void ESenior(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now());
        tipo.setCargo("senior");
        assertEquals(tipo.ESenior(),true);
    }
    @Test
    public void CalcularTempoContratacaoMeses(){
        TipoContratacao tipo = new TipoContratacao("pj",LocalDate.now().minusMonths(2));
        assertEquals(tipo.CalcularTempoContratacaoMeses(),2);

    }
}
