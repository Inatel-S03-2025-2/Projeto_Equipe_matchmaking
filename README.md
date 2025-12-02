# 📘 Documentação UML do Projeto – Matchmaking API
## 🎯 Diagrama de Casos de Uso

## 👥 Atores:

Player: Usuário que interage diretamente com o sistema.

Players: Conjunto de jogadores disponíveis no matchmaking.

Database with Results: Repositório responsável por armazenar resultados e dados das partidas.

#  ⚙️ Casos de Uso:

Caso de Uso	Descrição
Match Making	Encontra partidas equilibradas entre jogadores com base no ranking.
Ranking Validator	Valida e ajusta o ranking dos jogadores para garantir partidas justas.
GET USER INFORMATIONS	Consulta informações detalhadas de um jogador.
Get Match Results	Obtém os resultados das partidas realizadas.
Share Results	Permite compartilhar os resultados com outros serviços ou sistemas externos.

# 🔗 Relações entre Casos de Uso:

Match Making inclui:

Ranking Validator

Get User Informations

Get Match Results depende de Database with Results.

# 🧩 Diagrama de Classes

## 🏗️ Classe: RankingValidatorRepository

Atributos: id, resultado, ranking

Métodos: iniciar(), finalizar(), getMatchResults(), validarRanking()

## 🧱 Classe: FilaDeBatalha

Atributos: fila: List<Jogador>

Métodos: adicionar(id, ranking), remover(id), puxarJogador()

## 🧍 Classe: Jogador

Atributos: id, ranking, estatísticas

Métodos: participarBatalha(), atualizarRanking(id, resultado)

## ⚔️ Classe: BatalhaService

Atributos: id, resultado, jogadores: List<Jogador>

Métodos: formarBatalha(), atualizarBanco(), compartilharResultados()

## 📊 Classe: RankingRepository

Atributos: id, rankingAtual, historicoDePartidas

Métodos: atualizarRanking(), consultarRanking()

## 🔁 Relações Gerais entre as Classes:

BatalhaService usa FilaDeBatalha (use) para formar partidas.

RankingValidatorRepository valida dados em RankingRepository.

Jogador é essencial para FilaDeBatalha e BatalhaService.

Database with Results armazena dados processados por RankingRepository e BatalhaService.

## 🧩 Resumo Arquitetural

O sistema Matchmaking tem como objetivos:

Formar partidas equilibradas com base em ranking e estatísticas.

Garantir integridade e consistência das informações.

Permitir compartilhamento de resultados e integração com bases externas.

A arquitetura é modular, extensível e baseada em SOA, com mínimo acoplamento entre componentes.

## 🧱 Estrutura de Pastas — Arquitetura SOA
```
projeto_equipe_magma/
│
├── services/
│   ├── matchmaking_service/
│   │   ├── entities/        # Match, Player, MatchQueue
│   │   ├── usecases/        # CreateMatch, AddPlayerToQueue, PairPlayers
│   │   ├── services/        # RankingValidatorService, QueueService, MatchmakingRulesService
│   │   ├── repositories/    # MatchRepository, PlayerRepository, QueueRepository
│   │   └── dtos/            # MatchDTO, PlayerDTO, QueueDTO
│
├── ranking_service/         # Lógica de ranking, cálculo MMR, etc.
├── results_service/         # Processamento e armazenamento de resultados
├── user_service/            # Informações e atualização de usuários
├── shared/                  # Reutilizáveis: DTOs, Entities, Configs, Utils
├── docs/                    # UML e documentação
├── tests/                   # Testes unitários e integração
├── .gitignore
└── README.md
```

# ⚙️ Explicação do Design
```
| Camada         | Responsabilidade                         | Exemplo                               |
|----------------|-----------------------------------------|---------------------------------------|
| services/      | Cada módulo isolado com sua lógica e banco | matchmaking_service, ranking_service |
| shared/        | Código e modelos reutilizáveis           | Configurações, DTOs, utilitários     |
| docs/          | Documentação UML e regras de negócio    | Diagramas, casos de uso              |
| api_gateway/   | Centraliza rotas, autenticação e logs   | JWT, rate limiting, logging          |
| docker/        | Orquestração de containers              | Subir todos os serviços localmente   |
| scripts/       | Automatizações e CI/CD                   | Build, testes, deploy                |

```

# 🔌 Comunicação entre Serviços

HTTP/REST: integração leve e síncrona.

Mensageria (RabbitMQ/Kafka): eventos como partida iniciada ou ranking atualizado.

Banco compartilhado (somente leitura): consultas conjuntas.

# 💡 Design Pattern Utilizado:

SOA (Service-Oriented Architecture): cada módulo é um serviço independente.

DTO Pattern: separa dados de transporte de lógica de domínio.

Factory Pattern (PlayerFactory) para criação de objetos Player.

# 🌐 Endpoints da API
## 📌 POST /api/matches
### Body (JSON):

```
{
  "playerAName": "Gab",
  "playerAId": "1",
  "playerBName": "Rafael",
  "playerBId": "2",
  "winner": "1"
}

```
## Resposta:
``` 
{
    "message": "Match registered successfully",
    "playerAId": "1",
    "playerBId": "2"
}
```
## 📌 GET /api/matches/players

### Exemplo de resposta:
```
[
    {
        "id": "1",
        "name": "Gab"
    },
    {
        "id": "2",
        "name": "Rafael"
    }
]
```
## 📌 GET /api/matches

## Exemplo de resposta:
```
[
    {
        "playerAName": "Gab",
        "playerAId": "1",
        "playerBName": "Rafael",
        "playerBId": "2",
        "winner": "1"
    }
]
```