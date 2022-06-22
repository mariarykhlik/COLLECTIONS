package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "First", 10);
    Player player2 = new Player(2, "Second", 5);
    Player player3 = new Player(3, "Third", 10);

    @Test
    public void shouldRoundForWin() {

        game.register(player1);
        game.register(player2);

        int actual = game.round("First", "Second");

        assertEquals(1, actual);
    }

    @Test
    public void shouldRoundForLose() {

        game.register(player2);
        game.register(player3);

        int actual = game.round("Second", "Third");

        assertEquals(2, actual);
    }

    @Test
    public void shouldRoundForDraw() {

        game.register(player1);
        game.register(player3);

        int actual = game.round("Third", "First");

        assertEquals(0, actual);
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForFirst() {

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("First", "Second");
        });
    }

    @Test
    public void shouldThrowNotRegisteredExceptionForSecond() {

        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("First", "Second");
        });
    }
}