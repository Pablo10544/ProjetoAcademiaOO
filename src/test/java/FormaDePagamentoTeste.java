import org.example.FormaDePagamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormaDePagamentoTeste {
    @Test
    public void setTipoCartao(){
        FormaDePagamento forma = new FormaDePagamento("cartao","pago",100);
        assertEquals(forma.getTipo(),"cartao");
    }
    @Test
    public void setTipoDinheiro(){
        FormaDePagamento forma = new FormaDePagamento("dinheiro","pago",100);
        assertEquals(forma.getTipo(),"dinheiro");
    }
    @Test
    public void setTipoPix(){
        FormaDePagamento forma = new FormaDePagamento("pix","pago",100);
        assertEquals(forma.getTipo(),"pix");
    }
    @Test
    public void SetTipoInvalido(){
      Exception ex = assertThrows( IllegalArgumentException.class ,()->{FormaDePagamento forma = new FormaDePagamento("lala","pago",100);});
        assertEquals(ex.getMessage(),"Tipo da forma de pagamento inválido!");
    }
    @Test
    public void setStatusPago(){
        FormaDePagamento forma = new FormaDePagamento("pix","pago",100);
        assertEquals(forma.getStatus(),"pago");
    }
    @Test
    public void setStatusEmProcessamento(){
        FormaDePagamento forma = new FormaDePagamento("pix","em processamento",100);
        assertEquals(forma.getStatus(),"em processamento");
    }
    @Test
    public void setStatusAguardandoPagamento(){
        FormaDePagamento forma = new FormaDePagamento("pix","aguardando pagamento",100);
        assertEquals(forma.getStatus(),"aguardando pagamento");
    }
    @Test
    public void SetStatusInvalido(){
        Exception ex = assertThrows( IllegalArgumentException.class ,()->{FormaDePagamento forma = new FormaDePagamento("pix","aaaa",100);});
        assertEquals(ex.getMessage(),"status inválido!");
    }
    @Test
    public void setValor(){
        FormaDePagamento forma = new FormaDePagamento("pix","em processamento",100);
        assertEquals(forma.getValor(),100);
    }
    @Test
    public void setValorInvalido(){
        Exception ex = assertThrows( IllegalArgumentException.class ,()->{FormaDePagamento forma = new FormaDePagamento("pix","pago",-1);});
        assertEquals(ex.getMessage(),"Valor negativo!");
    }

}
