package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        board.startMatch("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        board.startMatch("Germany", "France");
        board.updateScore("Germany", "France", 2, 2);

        board.startMatch("Uruguay", "Italy");
        board.updateScore("Uruguay", "Italy", 6, 6);

        board.startMatch("Argentina", "Australia");
        board.updateScore("Argentina", "Australia", 3, 1);

        List<Match> scoreBoardSummary = board.getScoreBoardSummary();

        System.out.println(scoreBoardSummary);
    }
}