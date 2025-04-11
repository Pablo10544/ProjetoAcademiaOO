import org.example.Endereco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnderecoTeste {
    @Test
    public void setEstado(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        assertEquals(endereco.getEstado(),"RJ");

    }
    @Test
    public void setEstadoInvalido(){
       Exception ex = assertThrows(IllegalArgumentException.class,()->{ Endereco endereco = new Endereco("","Petrópolis","Centro","Rua da Imperatriz");});
        assertEquals(ex.getMessage(),"Estado inválido!");

    }
    @Test
    public void setCidade(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        assertEquals(endereco.getCidade(),"Petrópolis");

    }
    @Test
    public void setCidadeInvalido(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ Endereco endereco = new Endereco("RJ","","Centro","Rua da Imperatriz");});
        assertEquals(ex.getMessage(),"Cidade inválida!");

    }
    @Test
    public void setBairro(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        assertEquals(endereco.getBairro(),"Centro");
    }
    @Test
    public void setBairroInvalido(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ Endereco endereco = new Endereco("RJ","Petrópolis","","Rua da Imperatriz");});
        assertEquals(ex.getMessage(),"Bairro inválido!");

    }
    @Test
    public void setRua(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        assertEquals(endereco.getRua(),"Rua da Imperatriz");
    }
    @Test
    public void setRuaInvalido(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->{ Endereco endereco = new Endereco("RJ","Petrópolis","Centro","");});
        assertEquals(ex.getMessage(),"Rua inválida!");

    }
    @Test
    public void GetEnderecoCompleto(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        assertEquals(endereco.GetEnderecoCompleto(),"RJ, Petrópolis, Rua da Imperatriz, Centro");

    }
    @Test
    public void GetEnderecoCompletoComComplemento(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        endereco.setComplemento("sala 201");
        assertEquals(endereco.GetEnderecoCompleto(),"RJ, Petrópolis, Rua da Imperatriz, Centro, sala 201");

    }
    @Test
    public void GetEnderecoCompletoComCEP(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        endereco.setCEP("25685320");
        assertEquals(endereco.GetEnderecoCompleto(),"RJ, Petrópolis, Rua da Imperatriz, Centro, 25685320");

    }
    @Test
    public void GetEnderecoCompletoComTudo(){
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        endereco.setCEP("25685320");
        endereco.setComplemento("sala 201");
        assertEquals(endereco.GetEnderecoCompleto(),"RJ, Petrópolis, Rua da Imperatriz, Centro, sala 201, 25685320");

    }
}
