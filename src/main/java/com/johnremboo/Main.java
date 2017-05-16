package com.johnremboo;

/**
 * Created by Igor Orekhov on 16.05.17.
 */
public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        Player player1 = new Player("player1", dispatcher);
        player1.startConversation("player2", 10);

        Player player2 = new Player("player2", dispatcher);
        player2.startConversation("player1", 10);
    }
}
