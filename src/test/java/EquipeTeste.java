import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipeTeste {
    @Test
    public void GetEnderecoCompletoInstrutor(){
    TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
        instrutor.setEndereco(endereco);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        assertEquals(equipe.GetEnderecoCompletoInstrutor(instrutor),endereco.GetEnderecoCompleto());
    }
@Test
    public void GetEnderecoCompletoTecnico(){
    TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
    TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
    Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
    Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
    tec.setEndereco(endereco);
    ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
    ArrayList<Tecnico> tecnicos = new ArrayList<>();
    tecnicos.add(tec);
    Equipe equipe = new Equipe(tecnicos,instrutores);
    assertEquals(equipe.GetEnderecoCompletoTecnico(tec),endereco.GetEnderecoCompleto());
}
@Test
    public void GetTipoEquipamentoTecnicoFazManutencao(){
    TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
    TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
    Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
    ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
    ArrayList<Tecnico> tecnicos = new ArrayList<>();
    Equipe equipe = new Equipe(tecnicos,instrutores);
    assertEquals(    equipe.GetTipoEquipamentoTecnicoFazManutencao(tec),tipoe.getTipo());

    }
    @Test
    public void GetTipoContratacaoTecnico(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        assertEquals(    equipe.GetTipoContratacaoTecnico(tec),tipo.getTipo());

    }
    @Test
    public void ETecnico(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tec);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        assertEquals(    equipe.ETecnico(tec),true);
    }
    @Test
    public void ETecnicoFalso(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        assertEquals(    equipe.ETecnico(instrutor),false);
    }
    @Test
    public void nomeTecnicoConsertouMaisEquipamentos(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo,"Joana",32,tipoe);
        Manutencao man = new Manutencao(LocalDate.now(),1000f,tec2);
        tec2.AddManutencao(man);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tec);
        tecnicos.add(tec2);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        assertEquals(    equipe.nomeTecnicoConsertouMaisEquipamentos(),"Joana");
    }
    @Test
    public void NomesDosFuncionariosSeniors(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("clt", LocalDate.now());
        tipo2.setCargo("senior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Tecnico tec3 = new Tecnico(1000f,tipo2,"Maria",32,tipoe);
        Manutencao man = new Manutencao(LocalDate.now(),1000f,tec2);
        tec2.AddManutencao(man);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tec);
        tecnicos.add(tec3);
        tecnicos.add(tec2);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joana");
        nomesEsperados.add("Maria");
        ArrayList<String>  nomesRecebidos = new ArrayList<>();
        nomesRecebidos = equipe.NomesDosFuncionariosSeniors();
        Collections.sort(nomesRecebidos);
        Collections.sort(nomesEsperados);
        assertEquals(nomesEsperados,nomesRecebidos);
    }
    @Test
    public void NomeDosFuncionariosJuniors(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("clt", LocalDate.now());
        tipo.setCargo("junior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Tecnico tec3 = new Tecnico(1000f,tipo2,"Maria",32,tipoe);
        Manutencao man = new Manutencao(LocalDate.now(),1000f,tec2);
        tec2.AddManutencao(man);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tec);
        tecnicos.add(tec3);
        tecnicos.add(tec2);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joao");
        ArrayList<String>  nomesRecebidos = new ArrayList<>();
        nomesRecebidos = equipe.NomeDosFuncionariosJuniors();
        Collections.sort(nomesRecebidos);
        Collections.sort(nomesEsperados);
        assertEquals(nomesEsperados,nomesRecebidos);
    }
    @Test
    public void NomesDosFuncionariosClts(){
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("clt", LocalDate.now());
        tipo.setCargo("junior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Tecnico tec3 = new Tecnico(1000f,tipo2,"Maria",32,tipoe);
        Manutencao man = new Manutencao(LocalDate.now(),1000f,tec2);
        tec2.AddManutencao(man);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        tecnicos.add(tec);
        tecnicos.add(tec3);
        tecnicos.add(tec2);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joana");
        nomesEsperados.add("Maria");
        ArrayList<String>  nomesRecebidos = new ArrayList<>();
        nomesRecebidos = equipe.NomesDosFuncionariosClts();
        Collections.sort(nomesRecebidos);
        Collections.sort(nomesEsperados);
        assertEquals(nomesEsperados,nomesRecebidos);
    }
}
