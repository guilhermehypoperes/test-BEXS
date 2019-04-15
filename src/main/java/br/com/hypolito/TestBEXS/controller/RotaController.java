package br.com.hypolito.TestBEXS.controller;

import br.com.hypolito.TestBEXS.TestBexsConsoleApplication;
import br.com.hypolito.TestBEXS.negocio.ClassificadorDeRota;
import br.com.hypolito.TestBEXS.negocio.GerenciadorDeArquivoRota;
import org.springframework.web.bind.annotation.*;

@RestController("rota")
public class RotaController {

    @GetMapping("bestRoute")
    public String getBestRoute(@RequestParam(value = "route",defaultValue = "") String route) throws Exception {
        return new ClassificadorDeRota().buscaMelhorRota(route,TestBexsConsoleApplication.getArquivoDeRotas());
    }

    @PostMapping("saveRoute")
    public void saveRoute(@RequestBody String route) throws Exception {
        new GerenciadorDeArquivoRota().saveRoute(route);
    }


}
