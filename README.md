# 🎬 ScreenMatch

Aplicação desenvolvida em **Java** para consulta e organização de informações sobre filmes e séries a partir de APIs externas.

O projeto começou como uma aplicação de console para praticar **Programação Orientada a Objetos, coleções e consumo de APIs REST** e evoluiu para trabalhar também com **desserialização de JSON, integração com serviços externos e tradução automática de sinopses**.

> Projeto desenvolvido com foco em estudos e evolução prática em desenvolvimento Backend com Java.

---

## 🚀 Sobre o projeto

O **ScreenMatch** permite pesquisar séries utilizando a **OMDb API**, obter informações como título, avaliação, número de temporadas, atores, gênero, pôster e sinopse e armazenar os resultados durante a execução da aplicação.

As sinopses retornadas pela OMDb em inglês também podem ser enviadas para uma API de tradução, permitindo apresentar o conteúdo em português.

O projeto utiliza o `HttpClient` nativo do Java para realizar as requisições HTTP e **Gson** para converter os dados JSON em objetos Java.

---

## ✨ Funcionalidades

### 🔎 Consulta de séries

O usuário informa o nome de uma série e a aplicação realiza uma consulta à OMDb API.

Exemplo:

```text
Digite o nome da Serie:
The Office
```

A aplicação obtém informações como:

- 🎬 Título;
- 📅 Ano;
- ⭐ Avaliação;
- 📺 Número de temporadas;
- 🎭 Atores;
- 🎞️ Gênero;
- 🖼️ URL do pôster;
- 📝 Sinopse.

---

### 🌎 Tradução de sinopses

As sinopses originalmente retornadas em inglês podem ser enviadas para um serviço de tradução.

Fluxo da aplicação:

```text
OMDb API
   │
   │ JSON
   ▼
DadosSerie
   │
   │ sinopse em inglês
   ▼
Tradutor
   │
   ▼
LibreTranslate
   │
   │ tradução
   ▼
Sinopse em português
   │
   ▼
Objeto Serie
```

A integração foi implementada utilizando uma requisição `POST`.

---

### 📚 Lista de séries pesquisadas

As séries consultadas durante a execução da aplicação são armazenadas em uma coleção em memória.

O usuário pode acessar a opção de listagem para visualizar as séries pesquisadas.

---

### 📺 Consulta de episódios

O projeto também possui uma funcionalidade destinada à consulta de episódios relacionados às séries pesquisadas.

---

### 🔄 Menu interativo

A aplicação possui menus de navegação em console, permitindo que o usuário execute diferentes operações sem precisar reiniciar o programa.

Exemplo:

```text
****       ****         SCREEN MATCH SERIES        ****        ****

1 - Buscar Séries
2 - Buscar Episódios
3 - Listar Series Buscadas

0 - Sair
```

O menu permanece em execução até que o usuário escolha a opção `0`.

---

# 🛠️ Tecnologias utilizadas

## Java

O projeto utiliza recursos da linguagem Java para construção da aplicação, incluindo:

- Java;
- Programação Orientada a Objetos;
- Records;
- Generics;
- Collections;
- `HttpClient`;
- tratamento de exceções;
- `try/catch`;
- manipulação de strings;
- estruturas condicionais e de repetição.

---

## 🌐 APIs REST

### OMDb API

Utilizada como fonte dos dados de filmes e séries.

A aplicação realiza requisições HTTP para consultar informações sobre o conteúdo pesquisado.

```text
Java
  │
  │ GET
  ▼
OMDb API
  │
  │ JSON
  ▼
Aplicação
```

---

### 🌎 LibreTranslate

Utilizada para realizar a tradução das sinopses.

A aplicação envia uma requisição `POST` contendo os dados da tradução:

```json
{
  "q": "A mockumentary on a group of typical office workers...",
  "source": "en",
  "target": "pt",
  "format": "text"
}
```

A resposta esperada possui o texto traduzido:

```json
{
  "translatedText": "Um falso documentário sobre um grupo de trabalhadores..."
}
```

Para desenvolvimento local, o projeto pode utilizar uma instância do LibreTranslate executada localmente.

---

## 🔄 Gson

A biblioteca **Gson** é utilizada para converter os objetos Java em JSON e JSON em objetos Java.

Exemplo:

```java
DadosSerie dados =
        converteDados.obterDadosDoJsonParaObjeto(
                json,
                DadosSerie.class
        );
```

Para a comunicação com a API de tradução, o processo inverso também é utilizado:

```text
Objeto Java
     ↓
Gson
     ↓
JSON
     ↓
API
```

E:

```text
JSON
 ↓
Gson
 ↓
Objeto Java
```

---

# 🏗️ Estrutura da aplicação

A aplicação foi organizada buscando separar as responsabilidades de cada componente.

Uma visão simplificada da arquitetura:

```text
                    ┌────────────────────┐
                    │      Usuário        │
                    └─────────┬──────────┘
                              │
                              ▼
                    ┌────────────────────┐
                    │     Controller     │
                    │       Menu         │
                    └─────────┬──────────┘
                              │
                 ┌────────────┴────────────┐
                 │                         │
                 ▼                         ▼
        ┌────────────────┐        ┌────────────────┐
        │  ConsumoAPI    │        │    Tradutor    │
        └───────┬────────┘        └───────┬────────┘
                │                         │
                ▼                         ▼
          ┌───────────┐            ┌───────────────┐
          │ OMDb API  │            │ LibreTranslate │
          └─────┬─────┘            └───────┬───────┘
                │                          │
                └──────────┬───────────────┘
                           ▼
                    ┌───────────────┐
                    │   ConverteDados│
                    │     / Gson     │
                    └───────┬───────┘
                            │
                            ▼
                    ┌───────────────┐
                    │     Serie     │
                    └───────────────┘
```

---

# 📦 Principais componentes

## `ConsumoAPI`

Responsável pela comunicação HTTP com os serviços externos.

A aplicação possui métodos para realizar requisições `GET` e `POST`.

### GET

Utilizado para consultar informações na OMDb:

```java
public String obterDados(String endereco)
```

### POST

Utilizado para enviar informações para o serviço de tradução:

```java
public String enviarDados(String endereco, String json)
```

Essa separação permite reutilizar a classe para diferentes tipos de comunicação HTTP.

---

## `ConverteDados`

Centraliza a conversão entre JSON e objetos Java utilizando Gson.

Exemplo:

```java
public <T> T obterDadosDoJsonParaObjeto(
        String json,
        Class<T> classe
)
```

O uso de **Generics** permite que o mesmo método seja reutilizado para diferentes DTOs.

---

## `Tradutor`

Responsável pela integração com o serviço de tradução.

Seu fluxo é:

```text
Texto
 ↓
DadosTraducaoRequest
 ↓
Gson
 ↓
JSON
 ↓
POST
 ↓
LibreTranslate
 ↓
JSON
 ↓
DadosTraducao
 ↓
Texto traduzido
```

---

## `DadosSerie`

DTO utilizado para representar os dados retornados pela OMDb API.

A utilização de DTOs evita acoplar diretamente o retorno da API à estrutura de domínio utilizada pela aplicação.

---

## `DadosTraducaoRequest`

Objeto utilizado para representar os dados enviados à API de tradução.

```java
public record DadosTraducaoRequest(
        String q,
        String source,
        String target,
        String format
) {
}
```

---

## `DadosTraducao`

Representa a resposta retornada pelo serviço de tradução:

```java
public record DadosTraducao(
        String translatedText
) {
}
```

---

## `Serie`

Representa a entidade utilizada pela aplicação para armazenar os dados processados da série.

A aplicação utiliza os dados recebidos da API para construir o objeto e manter a informação da sinopse traduzida.

---

# 🔐 Tratamento de erros

A comunicação com APIs externas está sujeita a falhas de rede, respostas inválidas e indisponibilidade dos serviços.

Por isso, o projeto utiliza tratamento de exceções com `try/catch`.

Exemplo:

```java
try {
    // comunicação com a API
} catch (Exception e) {
    System.out.println(
            "Erro ao realizar a operação: "
                    + e.getMessage()
    );
}
```

Além de evitar que uma falha externa encerre a aplicação inesperadamente, o tratamento permite implementar comportamentos de fallback.

---

# 🔑 Configuração da OMDb API

Para utilizar o projeto é necessário possuir uma chave da **OMDb API**.

Depois de obter a chave, configure-a na aplicação.

O endereço utilizado segue o padrão:

```text
https://www.omdbapi.com/?t={TITULO}&apikey={API_KEY}
```

> ⚠️ Não publique sua API key diretamente no GitHub.

Para projetos públicos, recomenda-se utilizar variáveis de ambiente ou um arquivo de configuração que não seja versionado.

---

# 🌎 Configuração do LibreTranslate

Para evitar dependência da instância pública do LibreTranslate, o projeto pode utilizar uma instância local.

Com Docker:

```bash
docker compose up -d
```

O serviço ficará disponível localmente em:

```text
http://localhost:5000
```

A aplicação Java utiliza:

```java
private final String ENDERECO =
        "http://localhost:5000/translate";
```

Dessa maneira:

```text
Java
 │
 ▼
localhost:5000
 │
 ▼
LibreTranslate
```

não sendo necessário enviar as informações para uma instância externa durante o desenvolvimento local.

---

# ▶️ Como executar

## 1. Clonar o projeto

```bash
git clone https://github.com/eliascastrosousa/screenmatch.git
```

Entre no diretório:

```bash
cd screenmatch/projeto.screenmatch
```

---

## 2. Configurar a API

Configure sua chave da OMDb API conforme a estrutura utilizada no projeto.

---

## 3. Iniciar o LibreTranslate

Caso esteja utilizando a versão local:

```bash
docker compose up -d
```

Verifique se o container está em execução:

```bash
docker ps
```

---

## 4. Executar a aplicação

Abra o projeto em uma IDE compatível com Java, como:

- IntelliJ IDEA;
- Eclipse;
- Visual Studio Code.

Execute a classe principal da aplicação.

---

# 🧪 Exemplo de utilização

Após iniciar a aplicação:

```text
**** BEM VINDO AO SCREEN MATCH ****

1 - BUSCAR FILMES
2 - BUSCAR SERIES
0 - SAIR

DIGITE:
```

Ao selecionar a busca de séries:

```text
**** Buscar Séries ****

Digite o nome da Serie:
the office
```

A aplicação consulta a OMDb:

```text
sinopse original:
A mockumentary on a group of typical office workers,
where the workday consists of ego clashes,
inappropriate behavior, tedium and romance.
```

Depois envia a sinopse para o serviço de tradução.

O resultado esperado é uma sinopse em português:

```text
sinopse traduzida:
Um falso documentário sobre um grupo de trabalhadores
de escritório...
```

Por fim, os dados são armazenados no objeto `Serie` e adicionados à lista da aplicação.

---

# 📚 Conceitos praticados

Este projeto foi utilizado para consolidar conceitos importantes do desenvolvimento Backend com Java:

### Programação Orientada a Objetos

- Classes;
- Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Records;
- Interfaces.

### Java

- Collections;
- `ArrayList`;
- Generics;
- `HttpClient`;
- `HttpRequest`;
- `HttpResponse`;
- Streams;
- tratamento de exceções;
- `switch`;
- loops;
- text blocks.

### Integração

- Consumo de APIs REST;
- HTTP GET;
- HTTP POST;
- JSON;
- DTOs;
- Gson;
- integração com serviços externos.

### Boas práticas

- Separação de responsabilidades;
- reutilização de código;
- DTOs para comunicação externa;
- tratamento de exceções;
- organização por componentes;
- fallback para falhas externas.

---

# 🗺️ Fluxo completo da aplicação

```text
                     USUÁRIO
                        │
                        ▼
                Menu da aplicação
                        │
                        ▼
                 Busca por série
                        │
                        ▼
                  ConsumoAPI
                        │
                        │ GET
                        ▼
                    OMDb API
                        │
                        │ JSON
                        ▼
                   Gson / DTO
                        │
                        ▼
                    DadosSerie
                        │
                        ▼
                    Tradutor
                        │
                        │ POST
                        ▼
                LibreTranslate
                        │
                        │ JSON
                        ▼
                DadosTraducao
                        │
                        ▼
                 Sinopse em PT
                        │
                        ▼
                     Serie
                        │
                        ▼
                  listaSeries
```

---

# 🎯 Próximos passos

Algumas evoluções naturais para o projeto:

- [ ] Persistir séries em banco de dados;
- [ ] Criar uma API REST com Spring Boot;
- [ ] Separar Controller, Service e Repository;
- [ ] Criar endpoints para consulta das séries;
- [ ] Implementar paginação;
- [ ] Adicionar testes unitários;
- [ ] Criar testes de integração;
- [ ] Melhorar o tratamento de erros HTTP;
- [ ] Utilizar variáveis de ambiente para as chaves das APIs;
- [ ] Criar uma interface web para consumir a aplicação;
- [ ] Containerizar a aplicação com Docker.

---

# 👨‍💻 Autor

**Elias Castro**

Analista e Desenvolvedor de Sistemas.

### Tecnologias em estudo

```text
Java
Spring Boot
Spring Data JPA
REST APIs
Oracle / PL-SQL
MySQL
Docker
Git / GitHub
Python
```

---

## 📄 Licença

Projeto desenvolvido para fins de **estudo, prática e evolução profissional em desenvolvimento Backend com Java**.
