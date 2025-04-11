import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EquipamentoTeste {
    @Test
    public void setNome(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
    Equipamento equipamento = new Equipamento("Supino","funcionando",tipo);
    assertEquals(equipamento.getNome(),"Supino");
    }
    @Test
    public void setNomeInvalido(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
       Exception ex = assertThrows(IllegalArgumentException.class,()->{ Equipamento equipamento = new Equipamento("","funcionando",tipo);});
        assertEquals(ex.getMessage(),"Nome vazio!");
    }
    @Test
   public void setStatusFuncionando(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
        Equipamento equipamento = new Equipamento("Supino","funcionando",tipo);
        assertEquals(equipamento.getStatus(),"funcionando");
    }
    @Test
    public void setStatusEmManutencao(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
        Equipamento equipamento = new Equipamento("Supino","em manutencao",tipo);
        assertEquals(equipamento.getStatus(),"em manutencao");
    }
    @Test
    public void setStatusInvalido(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
        Exception ex = assertThrows(IllegalArgumentException.class,()->{  Equipamento equipamento = new Equipamento("Supino","lkl",tipo);});
        assertEquals(ex.getMessage(),"Status inválido!");
    }
    @Test
    public void GetCargoTecnico(){
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Equipamento equipamento = new Equipamento("Supino","em manutencao",tipoe);
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        Tecnico tec = new Tecnico(1000,tipo,"Joao",21,tipoe);
        Manutencao manutencao = new Manutencao(LocalDate.now(),1000f,tec);
        tipo.setCargo("pleno");
        assertEquals( equipamento.GetCargoTecnico(manutencao),"pleno");
    }
}
