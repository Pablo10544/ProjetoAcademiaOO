import org.example.Aluno;
import org.example.AvaliacaoFisica;
import org.example.Endereco;
import org.example.ValorFixo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AvaliacaoFisicaTeste {
    @Test
    public void GetEnderecoAvaliacaoFisica(){
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joana",20,valor);
        AvaliacaoFisica aval = new AvaliacaoFisica(LocalDate.now(),aluno);
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        aval.setEndereco(endereco);
    }
}
