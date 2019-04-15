package br.com.hypolito.TestBEXS;

import br.com.hypolito.TestBEXS.negocio.ClassificadorDeRota;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassificadorDeRotaTest {


    private ClassificadorDeRota classificadorDeRota;
    private File arquivoDeRotas;

    @Before
    public void preparaClassificadorDeRota() throws Exception {
        classificadorDeRota = new ClassificadorDeRota();
        arquivoDeRotas = new File("src/test/resources/input-file.txt");
    }

    @Test
    public void deveEntenderMelhorRotaBuscada() throws Exception {
        assertThat("GRU - BRC - SCL - ORL - CDG > $40.0",
                equalTo(classificadorDeRota.buscaMelhorRota("GRU-CDG",arquivoDeRotas)));
    }

    @Test
    public void deveEntenderTodasPossibilidadesDeRotas() throws Exception {
        assertThat(4,equalTo(classificadorDeRota.retornaRotasPossiveis("GRU-CDG",arquivoDeRotas).size()));
    }

    @Test
    public void deveEntenderRotaInformadaInvalida() throws Exception {
        assertThat(true,
                equalTo(classificadorDeRota.buscaMelhorRota("sdfasd",arquivoDeRotas).isEmpty()));
    }

    @Test
    public void deveEntenderRotaIndisponivel() throws Exception {
        assertThat("unavailable route",
                equalTo(classificadorDeRota.buscaMelhorRota("CDG-SCL",arquivoDeRotas)));
    }

    @Test
    public void deveEntenderRotaComDestinoEOrigemIguais() throws Exception {
        assertThat("unavailable route",
                equalTo(classificadorDeRota.buscaMelhorRota("CDG-CDG",arquivoDeRotas)));
    }


}
