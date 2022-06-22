package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player newPlayer) {
        players.add(newPlayer);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String name1, String name2) {
        if (findByName(name1) == null) {
            throw new NotRegisteredException("Player " + name1 + " not registered");
        }
        if (findByName(name2) == null) {
            throw new NotRegisteredException("Player " + name2 + " not registered");
        }
        if (findByName(name1).getStrength() > findByName(name2).getStrength()) {
            return 1;
        }
        if (findByName(name1).getStrength() < findByName(name2).getStrength()) {
            return 2;
        }
        return 0;
    }
}
