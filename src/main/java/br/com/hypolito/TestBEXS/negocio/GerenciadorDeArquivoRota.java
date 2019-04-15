package br.com.hypolito.TestBEXS.negocio;

import br.com.hypolito.TestBEXS.TestBexsConsoleApplication;
import br.com.hypolito.TestBEXS.model.Rota;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeArquivoRota {

    public ArrayList<Rota> leArquivoDeRota(File arquivo) throws Exception {

        ArrayList<Rota> listaDeRotas = new ArrayList<>();
        Scanner sc = new Scanner(arquivo);

        while (sc.hasNextLine()){
            String linha = sc.nextLine();
            listaDeRotas.add(new Rota(linha.split(",")[0],
                                        linha.split(",")[1],
                                            linha.split(",")[2]));
        }
        return listaDeRotas;
    }

    public void saveRoute(String route) throws Exception {
        if(ValidadorRota.validaStringRotaArquivo(route) && !exists(route)){
            FileWriter fileWriter = new FileWriter(TestBexsConsoleApplication.getArquivoDeRotas(),true);
            fileWriter.write("\n");
            fileWriter.write(route);
            fileWriter.close();
        }else
            throw new Exception("Erro ao registrar a rota no arquivo! " +
                                "Texto mal formato ou já cadastrado! ");
    }

    public Boolean exists(String route) throws Exception {
        ArrayList<Rota> rotas = leArquivoDeRota(TestBexsConsoleApplication.getArquivoDeRotas());
        if (!rotas.contains(new Rota(route.split(",")[0],
                                        route.split(",")[1],
                                            route.split(",")[2])))
            return false;
        else
            return true;
    }

}
