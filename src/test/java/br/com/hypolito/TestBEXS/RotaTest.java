package br.com.hypolito.TestBEXS;

import br.com.hypolito.TestBEXS.model.Rota;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RotaTest {

    private Rota rota;

    @Before
    public void iniciaRota(){
        rota = new Rota("GRU","CDG","100.0");
    }

    @Test
    public void deveEntenderRotaInicializada(){
        assertThat(rota.getOrigem(),equalTo("GRU"));
        assertThat(rota.getDestino(),equalTo("CDG"));
        assertThat(rota.getValor(),equalTo(100.0));
    }


}
