# Projeto_Equipe_Magma (matchmaking)
# Documentação UML do Projeto
## Diagrama de Casos de Uso
Atores

Player → Usuário que interage com o sistema.

Database with results → Repositório de dados que armazena resultados.

Players → Representa o conjunto de jogadores.

Casos de Uso

Match making → Responsável por encontrar partidas.

Ranking validator → Valida o ranking dos jogadores.

GET USER INFORMATIONS → Consulta as informações do usuário.

Get Match results → Obtém os resultados das partidas.

Relações

Uso de <<includes>> entre os casos de uso para indicar dependências funcionais.

## Diagrama de Classes
Classe: rankingValidatorRepository

Atributos

- id

- resultado

Métodos

+ iniciar()

+ finaliza()

+ getMatchResults()
