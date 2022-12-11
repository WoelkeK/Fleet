package app.model;

import java.io.Serializable;

class Message implements Serializable {

    private static final long serialVersionUID = 4L;

    String name;
    String body;

    public Message(String name, String body) {
        this.name = name;
        this.body = body;
    }
}