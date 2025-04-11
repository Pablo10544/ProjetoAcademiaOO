import org.example.TipoEquipamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipoEquipamentoTeste {
    @Test
    public void setTipo(){
        TipoEquipamento tipo = new TipoEquipamento("Força com placas de peso");
        assertEquals(tipo.getTipo(),"Força com placas de peso");
    }
}
