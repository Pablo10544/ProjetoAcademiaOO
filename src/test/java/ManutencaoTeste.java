import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManutencaoTeste {
    @Test
    public void setCusto(){
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        Tecnico tec = new Tecnico(1000,tipo,"Joao",21,tipoe);
        Manutencao manutencao = new Manutencao(LocalDate.now(),1000,tec);
    }
    @Test
    public void setCustoInvalido(){
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        Tecnico tec = new Tecnico(1000,tipo,"Joao",21,tipoe);
       Exception ex = assertThrows(IllegalArgumentException.class,()->{ Manutencao manutencao = new Manutencao(LocalDate.now(),-1,tec);});
        assertEquals(ex.getMessage(),"Custo negativo!");
    }
    @Test
    public void GetCargoTecnico(){
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        TipoContratacao tipo = new TipoContratacao("clt",LocalDate.now());
        tipo.setCargo("pleno");
        Tecnico tec = new Tecnico(1000,tipo,"Joao",21,tipoe);
        Manutencao manutencao = new Manutencao(LocalDate.now(),1000,tec);
        assertEquals(manutencao.GetCargoTecnico(),"pleno");
    }
}
