package com.johnremboo;

import java.util.HashMap;

/**
 * Created by Igor Orekhov on 16.05.17.
 * Exchange of information between threads is resolved by Dispatcher class. Dispatcher has Map of the Players
 * that are involved in the process of communication
 */
public class Dispatcher {
    private HashMap<String, Player> players = new HashMap<>();

    public void addPlayer(Player player) {
        players.put(player.getName(), player);
    }

    public boolean process(Message message) {
        System.out.println("from ---> " + message.getFrom() + " to ---> " + message.getTo() + " text ---> " + message.getText());
        return players.get(message.getTo()).receiveMessage(message);
    }
}
