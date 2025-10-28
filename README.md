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
├── services/                     # Cada serviço independente
│   ├── matchmaking_service/      # Serviço principal de matchmaking
│   │   ├── src/
│   │   │   ├── controllers/      # Controladores das rotas e lógica de entrada
│   │   │   ├── usecases/         # Casos de uso (matchmaking, pairing, etc.)
│   │   │   ├── entities/         # Entidades do domínio (Match, Player, etc.)
│   │   │   ├── repositories/     # Interfaces de acesso a dados
│   │   │   ├── services/         # Serviços auxiliares (fila, ranking validator)
│   │   │   ├── dtos/             # Data Transfer Objects (comunicação entre módulos)
│   │   │   ├── utils/            # Funções utilitárias e helpers
│   │   │   └── main.dart|ts|py   # Ponto de entrada do serviço
│   │   └── tests/                # Testes unitários e de integração
│   │
│   ├── ranking_service/          # Serviço independente de rankings
│   │   ├── src/
│   │   │   ├── controllers/
│   │   │   ├── usecases/
│   │   │   ├── entities/
│   │   │   ├── repositories/
│   │   │   ├── dtos/
│   │   │   └── main.dart|ts|py
│   │   └── tests/
│   │
│   ├── results_service/          # Serviço de resultados e estatísticas
│   │   ├── src/
│   │   │   ├── controllers/
│   │   │   ├── usecases/
│   │   │   ├── entities/
│   │   │   ├── repositories/
│   │   │   ├── dtos/
│   │   │   └── main.dart|ts|py
│   │   └── tests/
│   │
│   ├── user_service/             # Serviço de informações dos jogadores
│   │   ├── src/
│   │   │   ├── controllers/
│   │   │   ├── usecases/
│   │   │   ├── entities/
│   │   │   ├── repositories/
│   │   │   ├── dtos/
│   │   │   └── main.dart|ts|py
│   │   └── tests/
│   │
│   └── shared/                   # Recursos compartilhados entre serviços
│       ├── database/             # Configurações e modelos de acesso ao banco
│       ├── messaging/            # Fila, pub/sub, Kafka, RabbitMQ etc.
│       ├── config/               # Configurações globais (env, logs, etc.)
│       ├── utils/                # Funções utilitárias globais
│       └── dtos/                 # Objetos de transporte compartilhados
│
├── api_gateway/                  # Gateway unifica entrada de todos os serviços
│   ├── routes/
│   ├── middleware/
│   ├── controllers/
│   ├── security/                 # Autenticação, rate-limiting, JWT
│   ├── config/
│   └── main.dart|ts|py
│
├── docs/                         # Documentação UML, requisitos, diagramas
│   ├── UML_projeto_atualizado.drawio
│   ├── README.md
│   └── arquitetura_soa.md
│
├── scripts/                      # Scripts de automação, migrações e deploy
│
├── tests/                        # Testes de integração geral
│
├── docker/                       # Configurações de containerização
│   ├── matchmaking.Dockerfile
│   ├── ranking.Dockerfile
│   └── docker-compose.yml
│
├── .env                          # Variáveis de ambiente
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