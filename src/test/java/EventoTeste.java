import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventoTeste {
    @Test
    public void DataContratacaoInstrutor(){
        TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
        Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
        Evento evento = new Evento(LocalDate.now(),100,"Circuito de fit dance",instrutor);
        assertEquals(LocalDate.now(),evento.DataContratacaoInstrutor());
          }
          @Test
    public void GetTipoPagamentoParticipanteEvento(){
              TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
              Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
              ValorFixo valor = new ValorFixo(100);
              FormaDePagamento forma = new FormaDePagamento("dinheiro","pago",100);
              Aluno aluno = new Aluno("Joao",21,valor);
              valor.AddFormaDePagamento(forma);
              Evento evento = new Evento(LocalDate.now(),100,"Circuito de fit dance",instrutor);
              evento.AddParticipante(aluno);
              assertEquals("dinheiro",evento.GetTipoPagamentoParticipanteEvento(aluno));
          }
          @Test
    public void GetIdadeInstrutor(){
              TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
              Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
              Evento evento = new Evento(LocalDate.now(),100,"Circuito de fit dance",instrutor);
              assertEquals(evento.GetIdadeInstrutor(),32);

          }
          @Test
          public void GetEnderecoDaUltimaAvaliacaoFisicaInstrutor(){
              TipoContratacao tipo = new TipoContratacao("clt", LocalDate.now());
              Instrutor instrutor = new Instrutor(1000f,tipo,"Joao",32);
              ValorFixo valor = new ValorFixo(100);
              Aluno aluno = new Aluno("Joana",20,valor);
              Endereco endereco = new Endereco("RJ","Petrópolis","Centro","Rua da Imperatriz");
              AvaliacaoFisica aval = new AvaliacaoFisica(LocalDate.now(),aluno);
              instrutor.AddAvaliacaoFisica(aval);
              aval.setEndereco(endereco);
              Evento evento = new Evento(LocalDate.now(),100,"Circuito de fit dance",instrutor);
              assertEquals(evento.GetEnderecoDaUltimaAvaliacaoFisicaInstrutor(),endereco.GetEnderecoCompleto());
          }
}
