import org.example.Funcionario;
import org.example.TipoContratacao;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioTeste {
@Test
    public void setSalario(){
    TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
    Funcionario func = new Funcionario(1000,tipo,"Joao",29);
    assertEquals(func.getSalario(),1000);
}
@Test
    public void setSalarioInvalido(){
    TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
    Exception ex = assertThrows(IllegalArgumentException.class,()->{ Funcionario func = new Funcionario(-1,tipo,"Joao",29);});
    assertEquals(ex.getMessage(),"Salario negativo");
    }
    @Test
    public void GetTipoContratacaoFuncionario(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        assertEquals(func.GetTipoContratacaoFuncionario(),"clt");
    }
    @Test

    public void GetCargoContratado(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        tipo.setCargo("senior");
        assertEquals("senior",func.GetCargoContratado());
    }
    @Test

    public void GetDataContratacao(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        assertEquals(LocalDate.now(),func.GetDataContratacao());

    }
    @Test

    public void EClt(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        assertEquals(func.EClt(),true);
    }
    @Test

    public void ESenior(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        tipo.setCargo("senior");
        assertEquals(true,func.ESenior());
    }
    @Test
    public void EJunior(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Funcionario func = new Funcionario(1000,tipo,"Joao",29);
        tipo.setCargo("junior");
        assertEquals(true,func.EJunior());
    }
}

