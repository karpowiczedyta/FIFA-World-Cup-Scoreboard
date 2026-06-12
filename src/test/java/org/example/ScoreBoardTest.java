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

}


