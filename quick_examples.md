# Quick Examples

Create a match (A wins):
curl -X POST http://localhost:9090/api/v1/matchmaking/match \
 -H "Content-Type: application/json" \
 -d '{
   "playerAName": "Gab",
   "playerAId": "p-001",
   "playerBName": "Lucas",
   "playerBId": "p-002",
   "winner": "A"
 }'

List results:
curl http://localhost:9090/api/v1/matchmaking/results

List results for a player:
curl http://localhost:9090/api/v1/matchmaking/results/player/p-001
