package br.com.hypolito.TestBEXS;

import br.com.hypolito.TestBEXS.negocio.ClassificadorDeRota;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class TestBexsConsoleApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(TestBexsConsoleApplication.class);
	private static File arquivoDeRotas;

	public static void main(String[] args) {
		SpringApplication.run(TestBexsConsoleApplication.class, args);
	}

	@Override
	public void run(String... args){

		if (args.length > 0) {
			while (true) {
				arquivoDeRotas = new File(args[0]);
				if (arquivoDeRotas.exists() && arquivoDeRotas.getAbsolutePath().endsWith(".txt")) {

					try {

						Scanner in = new Scanner(System.in);
						System.out.println("please enter the route: ");
						String rota = in.nextLine();
						String bestRoute = new ClassificadorDeRota().buscaMelhorRota(rota.toUpperCase(),arquivoDeRotas);

						if(!bestRoute.isEmpty())
							System.out.println("best route: "+bestRoute);

					} catch (Exception e) {
						LOG.error("Erro ao ler o arquivo de rotas: "+ e.getMessage());
						break;
					}
				}else{
					LOG.error("Arquivo de rotas nao localizado!!!");
					break;
				}
			}
		}else
			LOG.error("Arquivo de rotas nao informado!!!");
	}

	public static File getArquivoDeRotas() {
		return arquivoDeRotas;
	}

	public static void setArquivoDeRotas(File arquivoDeRotas) {
		TestBexsConsoleApplication.arquivoDeRotas = arquivoDeRotas;
	}
}
