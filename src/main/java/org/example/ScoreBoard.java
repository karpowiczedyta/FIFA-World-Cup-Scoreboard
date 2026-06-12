package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    private final Map<String, Match> matches = new HashMap<>();
    private long sequenceNumber = 1;
    private final String UNDERSCORE = "_";

    public void startMatch(String homeTeam, String awayTeam) {
        validateTeamName(homeTeam);
        validateTeamName(awayTeam);

        if (homeTeam.equalsIgnoreCase(awayTeam)) {
            throw new IllegalArgumentException("Teams must be different");
        }

        String key = buildMatchMapKey(homeTeam, awayTeam);

        if (matches.containsKey(key)) {
            throw new IllegalArgumentException("Match already exists!");
        }

        matches.put(key, new Match(homeTeam, awayTeam, sequenceNumber++));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        String matchKey = buildMatchMapKey(homeTeam, awayTeam);

        if (!matches.containsKey(matchKey)) {
            throw new IllegalArgumentException("Match does not exist");
        }

        matches.remove(matchKey);
    }

    public void updateScore(String homeTeam, String awayTeam,
                            int homeScore, int awayScore) {
        validateScore(homeScore);
        validateScore(awayScore);

        Match match = matches.get(buildMatchMapKey(homeTeam, awayTeam));

        if (match == null) {
            throw new IllegalArgumentException("Match not found!");
        }

        match.updateScore(homeScore, awayScore);
    }

    public List<Match> getScoreBoardSummary() {
        return matches.values()
                .stream()
                .sorted(
                        Comparator
                                .comparingInt(Match::getTotalScore)
                                .reversed()
                                .thenComparing(
                                        Match::getAdditionOrder,
                                        Comparator.reverseOrder()
                                )
                )
                .toList();
    }

    private String buildMatchMapKey(String homeTeam, String awayTeam) {
        return normalize(homeTeam) + UNDERSCORE + normalize(awayTeam);
    }

    private String normalize(String team) {
        return team.trim().toLowerCase();
    }

    private void validateTeamName(String team) {
        if (team == null || team.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or blank");
        }
    }

    private void validateScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
    }
}
