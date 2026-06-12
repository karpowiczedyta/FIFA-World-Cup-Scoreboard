package org.example;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long additionOrder;

    public Match(String homeTeam, String awayTeam, long additionOrder) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.additionOrder = additionOrder;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public long getAdditionOrder() {
        return additionOrder;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore
                + " - "
                + awayTeam + " " + awayScore;
    }

}
