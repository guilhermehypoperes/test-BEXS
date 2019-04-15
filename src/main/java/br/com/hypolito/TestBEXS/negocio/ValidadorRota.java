package br.com.hypolito.TestBEXS.negocio;

public class ValidadorRota {

    public static boolean validaStringRota(String rota){
        return ((rota.split("-").length == 2) &&
                    (rota.split("-")[0].length() == 3) &&
                        (rota.split("-")[1].length() == 3));
    }

    public static boolean validaStringRotaArquivo(String route) {
        return ((route.split(",").length == 3) &&
                    (route.split(",")[0].length() == 3) &&
                        (route.split(",")[1].length() == 3) &&
                            (Double.valueOf(route.split(",")[2]).equals(Double.valueOf(route.split(",")[2]))));
    }
}
