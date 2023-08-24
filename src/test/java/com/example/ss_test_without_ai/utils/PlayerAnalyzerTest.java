package com.example.ss_test_without_ai.utils;

import com.example.ss_test_without_ai.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerAnalyzerTest {
    private PlayerAnalyzer analyzer;
    private List<Player> players;

    @BeforeEach
    public void setUp() {
        analyzer = new PlayerAnalyzer();
        players = new ArrayList<>();
    }

    @Test
    public void testCalculateScoreNormalPlayer() {
        //Given
        players.add(new Player("Player1", 25, 5, List.of(2, 2, 2)));

        //When
        double score = analyzer.calculateScore(players);

        //Then
        assertEquals(250.0, score);
    }

    @Test
    public void testCalculateScoreJuniorPlayer() {
        //Given
        players.add(new Player("Player1", 15, 3, List.of(3, 3, 3)));

        //When
        double score = analyzer.calculateScore(players);

        //Then
        assertEquals(67.5, score);
    }

    @Test
    public void testCalculateScoreSeniorPlayer() {
        //Given
        players.add(new Player("Player1", 35, 15, List.of(4, 4, 4)));

        //When
        double score = analyzer.calculateScore(players);

        //Then
        assertEquals(2520.0, score);
    }

    @Test
    public void testCalculateScoreMultiplePlayers() {
        //Given
        players.add(new Player("Player1", 25, 5, List.of(2, 2, 2)));
        players.add(new Player("Player2", 15, 3, List.of(3, 3, 3)));
        players.add(new Player("Player3", 35, 15, List.of(4, 4, 4)));

        //When
        double score = analyzer.calculateScore(players);

        //Then
        assertEquals(2837.5, score);
    }

    @Test
    public void testCalculateScoreSkillsIsNull() {
        //When
        players.add(new Player("Player1", 25, 5, null));

        //Then
        assertThrows(NullPointerException.class, () -> analyzer.calculateScore(players));
    }

    @Test
    public void testCalculateScoreEmptyArray() {
        //When
        double score = analyzer.calculateScore(players);

        //Then
        assertEquals(0.0, score);
    }
}