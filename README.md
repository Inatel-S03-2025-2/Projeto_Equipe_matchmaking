# 📘 Documentação UML do Projeto
## 🎯 Diagrama de Casos de Uso
👥 Atores

Player → Usuário que interage diretamente com o sistema.

Players → Representa o conjunto de jogadores disponíveis no matchmaking.

Database with Results → Repositório responsável por armazenar resultados e dados das partidas.

# ⚙️ Casos de Uso
```
| **Caso de Uso**           | **Descrição**                                                                 |
|----------------------------|------------------------------------------------------------------------------|
| `Match Making`             | Responsável por encontrar partidas equilibradas entre jogadores com base no ranking. |
| `Ranking Validator`        | Valida e ajusta o ranking dos jogadores para garantir partidas justas.        |
| `GET USER INFORMATIONS`    | Consulta informações detalhadas de um jogador.                               |
| `Get Match Results`        | Obtém os resultados das partidas realizadas.                                 |
| `Share Results`            | Permite compartilhar os resultados obtidos com outros serviços ou sistemas externos. |
```
🔗 Relações entre Casos de Uso

Utilização de <<includes>> para indicar dependências funcionais entre os casos de uso.

O caso de uso Match Making inclui:

Ranking Validator

Get User Informations

O caso de uso Get Match Results depende de Database with Results.

# 🧩 Diagrama de Classes
## 🏗️ Classe: RankingValidatorRepository

Atributos

id

resultado

ranking

Métodos

+ iniciar()

+ finalizar()

+ getMatchResults()

+ validarRanking()

## 🧱 Classe: FilaDeBatalha

Atributos

fila: List<Jogador>

Métodos

+ adicionar(id, ranking)

+ remover(id)

+ puxarJogador()

## 🧍 Classe: Jogador

Atributos

id

ranking

estatísticas

Métodos

+ participarBatalha()

+ atualizarRanking(id, resultado)

## ⚔️ Classe: BatalhaService

Atributos

id

resultado

jogadores: List<Jogador>

Métodos

+ formarBatalha()

+ atualizarBanco()

+ compartilharResultados()

## 📊 Classe: RankingRepository

Atributos

id

rankingAtual

historicoDePartidas

Métodos

+ atualizarRanking()

+ consultarRanking()

## 🔁 Relações Gerais entre as Classes

BatalhaService utiliza (<<use>>) FilaDeBatalha para formar partidas entre jogadores.

RankingValidatorRepository realiza a validação dos dados em RankingRepository.

Jogador é uma entidade essencial para FilaDeBatalha e BatalhaService.

Database with Results armazena os dados processados por RankingRepository e BatalhaService.

## 🧩 Resumo Arquitetural

O sistema Matchmaking do projeto Equipe Magma tem como objetivo:

Formar partidas equilibradas com base em ranking e estatísticas dos jogadores.

Garantir a integridade e consistência das informações de ranking.

Permitir compartilhamento de resultados e integração com bases externas.

A arquitetura é modular e extensível, permitindo evolução futura com mínimo acoplamento entre componentes.

# 🧱 Estrutura de Pastas — Arquitetura SOA

```
src/
 ├── main/
 │    ├── java/com/matchmaking/
 │    │      ├── MatchmakingApiApplication.java
 │    │      ├── config/
 │    │      │      └── SwaggerConfig.java
 │    │      ├── controller/
 │    │      │      ├── MatchController.java
 │    │      │      └── PlayerController.java
 │    │      ├── domain/
 │    │      │      └── Player.java
 │    │      ├── dto/
 │    │      │      ├── MatchRequest.java
 │    │      │      └── MatchResponse.java
 │    │      ├── repository/
 │    │      │      └── PlayerRepository.java
 │    │      ├── service/
 │    │      │      └── MatchService.java
 │    │      └── util/
 │    │             └── PlayerFactory.java
 │    └── resources/
 │           ├── application.properties
 │           └── schema.sql
 └── test/
      └── java/com/matchmaking/service/MatchServiceTest.java

```

# ⚙️ Explicação do Design
```
| **Camada**      | **Responsabilidade**                            | **Exemplo**                                  |
|------------------|--------------------------------------------------|----------------------------------------------|
| `services/`      | Cada módulo isolado com sua lógica e banco       | `matchmaking_service`, `ranking_service`     |
| `api_gateway/`   | Centraliza todas as rotas e autenticação         | `JWT`, `rate limiting`, `logging`            |
| `shared/`        | Códigos e modelos reutilizados                   | Configurações, DTOs, utilitários             |
| `docs/`          | Tudo sobre documentação e UML                    | Diagramas, regras de negócio                 |
| `docker/`        | Orquestração de containers                       | Subir todos os serviços localmente           |
| `scripts/`       | Automatizações e CI/CD                           | Build, testes, deploy                        |

```
🔌 Comunicação entre Serviços

HTTP/REST → Ideal para integração leve e comunicação síncrona.

Mensageria (RabbitMQ / Kafka) → Usado para envio de eventos como partida iniciada, ranking atualizado, resultado processado.

Banco compartilhado (apenas leitura) → Usado apenas para consultas conjuntas (não para escrita simultânea).

# Endpoints (summary)

## POST /api/v1/matchmaking/match
- Body (application/json):
  {
    "playerAName": "Gab",
    "playerAId": "p-001",
    "playerBName": "Lucas",
    "playerBId": "p-002",
    "winner": "A"
  }
- Response:
  {
    "message": "Partida registrada com sucesso",
    "playerAPoints": 20,
    "playerBPoints": -10
  }

## GET /api/v1/matchmaking/results
- Returns list of match results.

## GET /api/v1/matchmaking/results/player/{playerId}
- Returns matches where the player participated.
