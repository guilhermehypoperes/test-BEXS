package br.com.hypolito.TestBEXS.negocio;

import br.com.hypolito.TestBEXS.TestBexsConsoleApplication;
import br.com.hypolito.TestBEXS.model.Rota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClassificadorDeRota {

    private static Logger LOG = LoggerFactory.getLogger(ClassificadorDeRota.class);

    private String descRotaFinal = "";
    private String descRota = "";
    private String destinoFinal = "";
    private String origemInicial = "";
    private Boolean primeiraPassagem = true;
    private Double valorFinal = Double.MAX_VALUE;
    private Double valor = Double.MIN_VALUE;
    private ArrayList<String> todasAsPossibilidades = new ArrayList<>();

    //método recursivo
    public String buscaMelhorRota(String rota, File arquivoDeRotas) throws Exception {

        //verifica se é uma rota válida
        if(!ValidadorRota.validaStringRota(rota)){
            LOG.error("Rota informada inválida!");
            return "";
        }

        //carrega em memória rotas escritas no arquivo
        ArrayList<Rota> listaDeRotas = new GerenciadorDeArquivoRota().leArquivoDeRota(arquivoDeRotas);

        String origem = rota.split("-")[0];
        String destino = rota.split("-")[1];

        //inválida iteração quando origem e destino forem iguais
        if(origem.equals(destino)){
            return "unavailable route";
        }

        //inicializa variáveis quando for a primeira iteração
        if(primeiraPassagem){
            destinoFinal = destino;
            primeiraPassagem = false;
            descRotaFinal = origem + " - ";
            descRota = origem + " - ";
            origemInicial = origem;
        }

        //busca rotas alternativas de acordo com a origem, excluindo rotas que cujo destino seja igual a origem inicial
        ArrayList<Rota> listaAlternativa = (ArrayList<Rota>) listaDeRotas.stream().
                filter(r -> r.getOrigem().equals(origem) && !r.getDestino().equals(origemInicial)).collect(Collectors.toList());

        for (Rota rotaAlternativa : listaAlternativa) {

            //caso o destino da rota alternativa já esteja na rota que está sendo montada, ignora a rota
            if(!descRota.contains(rotaAlternativa.getDestino())){

                //prepara descrição e soma o valor da rota alternativa
                descRota = descRota + rotaAlternativa.getDestino() + " - ";
                valor = valor + rotaAlternativa.getValor();

                if(rotaAlternativa.getDestino().equals(destinoFinal)){

                    descRota = descRota.replace(rotaAlternativa.getDestino()+" - ",rotaAlternativa.getDestino());

                    //guarda rota válida na lista de possibilidades
                    if(!todasAsPossibilidades.contains(descRota+" > $"+valor.toString()))
                        todasAsPossibilidades.add(descRota+" > $"+valor.toString());

                    //caso for a rota válida com menor valor, atualiza
                    if(valor < valorFinal){
                        descRotaFinal = descRota;
                        valorFinal = valor;
                    }
                }

                //procura novas alternativas
                buscaMelhorRota(rotaAlternativa.getDestino()+"-"+destinoFinal, arquivoDeRotas);

                descRota = descRota.replace(rotaAlternativa.getDestino() + (descRota.endsWith(" - ") ? " - " : ""),"");
                valor = valor - rotaAlternativa.getValor();
            }

        }
        return !todasAsPossibilidades.isEmpty() ?  descRotaFinal+" > $"+valorFinal.toString() : "unavailable route";
    }

    public ArrayList<String> retornaRotasPossiveis(String rota, File arquivoDeRotas) throws Exception {
        buscaMelhorRota(rota,arquivoDeRotas);
        return todasAsPossibilidades;
    }
}
