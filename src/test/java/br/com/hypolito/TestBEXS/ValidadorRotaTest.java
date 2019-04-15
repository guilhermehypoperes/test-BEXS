package br.com.hypolito.TestBEXS;

import br.com.hypolito.TestBEXS.negocio.ValidadorRota;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidadorRotaTest {

    @Test
    public void deveEntenderRotaValida(){
        assertThat(ValidadorRota.validaStringRota("GRU-CDG"),equalTo(true));
    }

    @Test
    public void deveEntenderRotaInvalidaComApenasDestino(){
        assertThat(ValidadorRota.validaStringRota("GRU"),equalTo(false));
    }

    @Test
    public void deveEntenderRotaInvalidaVazia(){
        assertThat(ValidadorRota.validaStringRota(""),equalTo(false));
    }

    @Test
    public void deveEntenderStringRotaArquivoValida(){
        assertThat(ValidadorRota.validaStringRotaArquivo("CDG,GRU,150"),equalTo(true));
    }

    @Test
    public void deveEntenderStringRotaArquivoInvalidaVazia(){
        assertThat(ValidadorRota.validaStringRotaArquivo(""),equalTo(false));
    }

    @Test(expected = Exception.class)
    public void deveEntenderStringRotaArquivoValidaPrecoInvalido(){
        assertThat(ValidadorRota.validaStringRotaArquivo("CDG,GRU,preço"),equalTo(false));
    }

}
