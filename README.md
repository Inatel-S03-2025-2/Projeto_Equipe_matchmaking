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
projeto_equipe_magma/
│
├── services/                             
│   ├── matchmaking_service/
│   │   ├── entities/                     
│   │   │   ├── Match.dart|ts|java
│   │   │   ├── Player.dart|ts|java
│   │   │   └── MatchQueue.dart|ts|java
│   │   │
│   │   ├── usecases/                     
│   │   │   ├── CreateMatchUseCase.dart|ts|java
│   │   │   ├── AddPlayerToQueueUseCase.dart|ts|java
│   │   │   └── PairPlayersUseCase.dart|ts|java
│   │   │
│   │   ├── services/                     
│   │   │   ├── RankingValidatorService.dart|ts|java
│   │   │   ├── QueueService.dart|ts|java
│   │   │   └── MatchmakingRulesService.dart|ts|java
│   │   │
│   │   ├── repositories/                 
│   │   │   ├── MatchRepository.dart|ts|java
│   │   │   ├── PlayerRepository.dart|ts|java
│   │   │   └── QueueRepository.dart|ts|java
│   │   │
│   │   └── dtos/                       
│   │       ├── MatchDTO.dart|ts|java
│   │       ├── PlayerDTO.dart|ts|java
│   │       └── QueueDTO.dart|ts|java
│   │
│   ├── ranking_service/
│   │   ├── entities/
│   │   │   └── Ranking.dart|ts|java
│   │   ├── usecases/
│   │   │   ├── UpdateRankingUseCase.dart|ts|java
│   │   │   └── CalculateMMRUseCase.dart|ts|java
│   │   ├── services/
│   │   │   └── RankingCalculatorService.dart|ts|java
│   │   ├── repositories/
│   │   │   └── RankingRepository.dart|ts|java
│   │   └── dtos/
│   │       └── RankingDTO.dart|ts|java
│   │
│   ├── results_service/
│   │   ├── entities/
│   │   │   └── MatchResult.dart|ts|java
│   │   ├── usecases/
│   │   │   ├── SaveMatchResultUseCase.dart|ts|java
│   │   │   └── GenerateStatisticsUseCase.dart|ts|java
│   │   ├── services/
│   │   │   └── StatisticsService.dart|ts|java
│   │   ├── repositories/
│   │   │   └── ResultsRepository.dart|ts|java
│   │   └── dtos/
│   │       └── MatchResultDTO.dart|ts|java
│   │
│   ├── user_service/
│   │   ├── entities/
│   │   │   └── User.dart|ts|java
│   │   ├── usecases/
│   │   │   ├── GetUserInfoUseCase.dart|ts|java
│   │   │   └── UpdateUserInfoUseCase.dart|ts|java
│   │   ├── services/
│   │   │   └── UserDomainService.dart|ts|java
│   │   ├── repositories/
│   │   │   └── UserRepository.dart|ts|java
│   │   └── dtos/
│   │       └── UserDTO.dart|ts|java
│   │
│   └── shared/                   
│       ├── entities/
│       │   └── BaseEntity.dart|ts|java
│       ├── dtos/
│       │   └── BaseDTO.dart|ts|java
│       ├── services/
│       │   └── DomainEventService.dart|ts|java
│       ├── utils/
│       │   └── DateUtils.dart|ts|java
│       └── config/
│           └── EnvironmentConfig.dart|ts|java
│
├── docs/                       
│   ├── UML_projeto_atualizado.drawio
│   ├── arquitetura_soa.md
│   └── README.md
│
├── tests/ 
│
├── .gitignore
└── README.md


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

## POST /match
```
{
  "playerAName": "Gabriel",
  "playerAId": "001",
  "playerBName": "Lucas",
  "playerBId": "002",
  "winner": "A"
}

```