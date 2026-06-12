package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {

    private final Map<String, Match> matches = new HashMap<>();
    private long sequenceNumber = 1;
    private final String UNDERSCORE = "_";

    public void startMatch(String homeTeam, String awayTeam) {

        String key = buildMatchMapKey(homeTeam, awayTeam);

        if (matches.containsKey(key)) {
            throw new IllegalArgumentException("Match already exists!");
        }

        matches.put(key, new Match(homeTeam, awayTeam, sequenceNumber++));
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.remove(buildMatchMapKey(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam,
                            int homeScore, int awayScore) {

        Match match = matches.get(buildMatchMapKey(homeTeam, awayTeam));

        if (match == null) {
            throw new IllegalArgumentException("Match not found!");
        }

        match.updateScore(homeScore, awayScore);
    }

    public List<Match> getScoreBoardSummary() {
        return matches.values().stream().toList();
    }

    private String buildMatchMapKey(String homeTeam, String awayTeam) {
        return homeTeam + UNDERSCORE + awayTeam;
    }
}
