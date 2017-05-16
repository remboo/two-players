package com.johnremboo;

/**
 * Created by Igor Orekhov on 16.05.17.
 * Consists information about sender, receiver and text of the message
 */
public class Message {
    private String text;
    private String from;
    private String to;

    public Message(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
