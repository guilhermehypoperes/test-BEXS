package br.com.hypolito.TestBEXS;

import br.com.hypolito.TestBEXS.negocio.GerenciadorDeArquivoRota;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GerenciadorDeArquivoRotaTest {

    private File arquivoDeRota;
    private GerenciadorDeArquivoRota leitor;

    @Before
    public void preparaLeitorDeArquivo(){
        arquivoDeRota = new File("src/test/resources/input-file.txt");
        leitor = new GerenciadorDeArquivoRota();
    }

    @Test
    public void deveEntenderQuantidadeDeRotasNoArquivo() throws Exception {
        assertThat(7,equalTo(leitor.leArquivoDeRota(arquivoDeRota).size()));
    }


}
