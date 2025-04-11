import org.example.Manutencao;
import org.example.Tecnico;
import org.example.TipoContratacao;
import org.example.TipoEquipamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TecnicoTeste {
    @Test
    public void tamanhoManutencoes(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Manutencao m = new Manutencao(LocalDate.now(),1000,tec);
        Manutencao m2 = new Manutencao(LocalDate.now(),1000,tec);
        tec.AddManutencao(m);
        tec.AddManutencao(m2);
        assertEquals(tec.tamanhoManutencoes(),2);
    }
    @Test
    public void GetTipoEquipamentoManutencoes(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        assertEquals(tec.GetTipoEquipamentoManutencoes(),tipoe.getTipo());
    }
}
