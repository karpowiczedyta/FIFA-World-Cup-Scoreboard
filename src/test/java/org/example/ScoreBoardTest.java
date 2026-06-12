package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    @Test
    void shouldStartMatchWithInitialScoreZeroZero() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Mexico", "Canada");
        List<Match> scoreBoardSummary = board.getScoreBoardSummary();

        assertEquals(1, scoreBoardSummary.size());

        Match match = scoreBoardSummary.getFirst();

        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenStartingDuplicateMatch() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Mexico", "Canada");

        assertThrows(
                IllegalArgumentException.class,
                () -> board.startMatch("Mexico", "Canada")
        );
    }

    @Test
    void shouldFinishMatchAndRemoveItFromScoreBoard() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Mexico", "Canada");
        board.finishMatch("Mexico", "Canada");

        assertTrue(board.getScoreBoardSummary().isEmpty());
    }

    @Test
    void shouldUpdateMatchScore() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);

        Match match = board.getScoreBoardSummary().getFirst();

        assertEquals(0, match.getHomeScore());
        assertEquals(5, match.getAwayScore());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUpdatingNonExistingMatch() {
        ScoreBoard board = new ScoreBoard();

        assertThrows(
                IllegalArgumentException.class,
                () -> board.updateScore("Mexico", "Canada", 1, 0)
        );
    }

    @Test
    void shouldReturnMatchesOrderedByTotalScoreDescending() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Germany", "France");
        board.updateScore("Germany", "France", 2, 2);

        board.startMatch("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        List<Match> summary = board.getScoreBoardSummary();

        assertEquals("Spain", summary.get(0).getHomeTeam());
        assertEquals("Germany", summary.get(1).getHomeTeam());
    }

    @Test
    void shouldReturnMostRecentlyStartedMatchFirstWhenTotalScoresAreEqual() {
        ScoreBoard board = new ScoreBoard();

        board.startMatch("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);

        board.startMatch("Uruguay", "Italy");
        board.updateScore("Uruguay", "Italy", 6, 6);

        List<Match> summary = board.getScoreBoardSummary();

        assertEquals("Uruguay", summary.get(0).getHomeTeam());
        assertEquals("Spain", summary.get(1).getHomeTeam());
    }

    @Test
    void shouldReturnSummaryExactlyAsInRequirementExample() {
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

        List<Match> summary = board.getScoreBoardSummary();

        assertEquals("Uruguay", summary.get(0).getHomeTeam());
        assertEquals("Spain", summary.get(1).getHomeTeam());
        assertEquals("Mexico", summary.get(2).getHomeTeam());
        assertEquals("Argentina", summary.get(3).getHomeTeam());
        assertEquals("Germany", summary.get(4).getHomeTeam());
    }

}


