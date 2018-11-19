package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class Message {
    private String url;

    public Message(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(url, message.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
