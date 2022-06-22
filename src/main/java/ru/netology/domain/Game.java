package ru.netology.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }

    public void register(Player newPlayer) {
        players.put(newPlayer.getName(), newPlayer);
    }

    public Player findByName(String name) {
        return players.get(name);
    }

    public int round(String name1, String name2) {
        if (!players.containsKey(name1)) {
            throw new NotRegisteredException("Player " + name1 + " not registered");
        }
        if (!players.containsKey(name2)) {
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