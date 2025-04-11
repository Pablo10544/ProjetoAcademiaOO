import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AcademiaTeste {
    @Test
    public void setNome(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
    Academia academia = new Academia("Smart fit",300,20,equipe);
    assertEquals(academia.getNome(),"Smart fit");
    }
    @Test
    public void setNomeInvalido(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{Academia academia = new Academia("",300,20,equipe);});
        assertEquals(ex.getMessage(),"Nome vazio!");
    }
    @Test
    public void setCapacidadePessoas(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(300,academia.getCapacidadePessoas());
    }
    @Test
    public void setCapacidadePessoasInvalida(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{Academia academia = new Academia("Smart fit",0,20,equipe);});
        assertEquals(ex.getMessage(),"Capacidade Pessoas menor igual a zero!");
    }
    @Test
    public void setCapacidadeEquipamentos(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(20,academia.getCapacidadeEquipamentos());
    }
    @Test
    public void setCapacidadeEquipamentosInvalida(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Exception ex = assertThrows(IllegalArgumentException.class,()->{Academia academia = new Academia("Smart fit",300,0,equipe);});
        assertEquals(ex.getMessage(),"Capacidade Equipamentos menor igual a zero!");
    }
    @Test
    public void IdadeInstrutorEvento(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        Evento evento = new Evento(LocalDate.now(),100,"Corrida ao ar livre",instrutor);
        assertEquals(32, academia.IdadeInstrutorEvento(evento));
    }
    @Test
    public void GetValorPagarAluno(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        ValorFixo valor = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        assertEquals(academia.GetValorPagarAluno(aluno),100);

    }
    @Test
    public void PessoaEUmTecnicoCLT(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        tecnicos.add(tec);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(academia.PessoaEUmTecnicoCLT(tec),true);
    }
    @Test
    public void PessoaEUmTecnicoCLTNaoClt(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        assertEquals(academia.PessoaEUmTecnicoCLT(tec),false);
    }
    @Test
    public void PessoaEUmTecnicoCLTNaoTecnico(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        assertEquals(academia.PessoaEUmTecnicoCLT(instrutor),false);
    }
    @Test
    public void NomeDoTecnicoQueConsertouMaisEquipamentos(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo,"Joana",32,tipoe);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        tecnicos.add(tec);
        tecnicos.add(tec2);
        Manutencao man = new Manutencao(LocalDate.now(),1000,tec);
        tec.AddManutencao(man);
        Manutencao man2 = new Manutencao(LocalDate.now(),1000,tec);
        tec.AddManutencao(man2);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(academia.NomeDoTecnicoQueConsertouMaisEquipamentos(),"Joao");

    }
    @Test
    public void NomeDoAlunoQueMaisGastouComSessoesParticulares(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        Equipe equipe = new Equipe(tecnicos,instrutores);
        Academia academia = new Academia("Smart fit",300,20,equipe);
        ValorFixo valor = new ValorFixo(100);
        ValorFixo valor2 = new ValorFixo(100);
        Aluno aluno = new Aluno("Joao",20,valor);
        Aluno aluno2 = new Aluno("Maria",20,valor2);
        academia.AddAluno(aluno);
        academia.AddAluno(aluno2);
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Marcio",32);
        SessaoParticularComPersonal sessao = new SessaoParticularComPersonal(100f,1,instrutor);
        valor2.addSessoes(sessao);
        assertEquals(academia.NomeDoAlunoQueMaisGastouComSessoesParticulares(),"Maria");
    }
    @Test
    public void NomesFuncionariosSeniors(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("pj", LocalDate.now());
        tipo2.setCargo("senior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        tecnicos.add(tec);
        tecnicos.add(tec2);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joana");
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(academia.NomesFuncionariosSeniors(),nomesEsperados);
    }
    @Test
    public void NomesFuncionariosCLTs(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("clt", LocalDate.now());
        tipo2.setCargo("senior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        tecnicos.add(tec);
        tecnicos.add(tec2);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joana");
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(academia.NomesFuncionariosCLTs(),nomesEsperados);
    }
    @Test
    public void NomeFuncionariosJuniors(){
        ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        TipoContratacao tipo = new TipoContratacao("pj", LocalDate.now());
        TipoContratacao tipo2 = new TipoContratacao("pj", LocalDate.now());
        tipo.setCargo("junior");
        TipoEquipamento tipoe = new TipoEquipamento("Força com placas de peso");
        Tecnico tec = new Tecnico(1000f,tipo,"Joao",32,tipoe);
        Tecnico tec2 = new Tecnico(1000f,tipo2,"Joana",32,tipoe);
        Equipe equipe = new Equipe(tecnicos,instrutores);
        tecnicos.add(tec);
        tecnicos.add(tec2);
        ArrayList<String> nomesEsperados = new ArrayList<>();
        nomesEsperados.add("Joao");
        Academia academia = new Academia("Smart fit",300,20,equipe);
        assertEquals(academia.NomeFuncionariosJuniors(),nomesEsperados);
    }



}
