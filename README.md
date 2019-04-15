# Aplicação test Banco BEXS

Esta aplicação foi desenvolvida para resolver o caso proposto pelo Banco BEXS

### 1. Tecnologias utilizadas

* Java 1.8
* Spring Boot 2.1.4
  - Starter Web
  - Starter Test

### 2. Estrutura de arquivos e pacotes

```
TestBEXS\src
│
└───\main\java\br\com\hypolito\TestBEXS\
│   │  controller "Responsável por armazenar classes controllers do serviço REST"
│   │  model "Responsável por armazenar classes modelos"
│   │  negocio "Classe responsável por armazenar classes que executam as regras de negócio"
│
└───\test\java\br\com\hypolito\TestBEXS\ "Responsável por armazenar classes de teste"
```
### 3. Rodar o projeto local
> git clone https://github.com/guilhermehypoperes/test-BEXS.git

>mvn spring-boot:run -Dspring-boot.run.arguments="Input File"

### 4. API Rest

Foram desenvolvidas duas interfaces, uma para possibilitar a busca de melhor rota  eoutra para possibilitar o registro de uma nova rota no arquivo.

 Interface REST A: Tipo GET, Responsável por buscar a melhor rota de acordo com o parâmetro DE-PARA. Ex.: http://localhost:8080/bestRoute?route=CDG-GRU

Interface REST B: Tipo POST, Responsável por registrar uma nova rota no arquivo. Ex.: http://localhost:8080/saveRoute  parametro="CDG,GRU,150"

### 5. Importar e rodar através do Eclipse

>$ mvn eclipse:eclipse

Importar no Eclipse através da opção: "Existing projects into workspace"
