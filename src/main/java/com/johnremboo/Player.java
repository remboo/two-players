package com.johnremboo;

/**
 * Created by Igor Orekhov on 16.05.17.
 * Player details (is the player initiator, the number of messages it received e.t.c) and the logic of sending/receiving
 * messages is processed in the current class
 */
public class Player implements Runnable {

    private String name;

    private int messages;

    private final Dispatcher dispatcher;

    private boolean isInitiator = false;

    private Message receivedMessage = null;

    private int incomeMessages;

    private String to;

    public Player(String name, Dispatcher dispatcher) {
        this.name = name;
        this.dispatcher = dispatcher;
        dispatcher.addPlayer(this);
    }

    @Override
    public void run() {
        while (true) {
            sendMessage(new Message(name, to));
            if (incomeMessages == messages && isInitiator) {
                System.out.println(name + " received " + messages + " messages!");
                System.exit(0);
            }
        }
    }

    public boolean sendMessage(Message message) {
        try {
            synchronized (dispatcher) {
                if (receivedMessage == null) {
                    isInitiator = true;
                    message.setText("first_message");
                } else {
                    message.setText(receivedMessage.getText().concat("_message_" + MessageGenerator.getString()));
                }

                dispatcher.process(message);
                dispatcher.notify();
                dispatcher.wait();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean receiveMessage(Message message) {
        receivedMessage = message;
        incomeMessages++;
        return true;
    }

    public void startConversation(String to, int messages) {
        this.to = to;
        this.messages = messages;
        new Thread(this).start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
