package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class Message {
    private String url;

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

    public void setMensaje(String mensaje) {
        this.url = mensaje;
    }

    @Override
    public String toString() {
        return "Message{" +
                "url='" + url + '\'' +
                '}';
    }
}
