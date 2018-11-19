package com.codurance.ciccio_pasticcio;

import java.util.UUID;

public class Persistable< V> {
    public final UUID identifier;
    public final V entity;

    private Persistable(UUID identifier, V entity) {
        this.identifier = identifier;
        this.entity = entity;
    }

    public static <V> Persistable of(V entity){
        return new Persistable(UUID.randomUUID(), entity);
    }

    public static <V> Persistable from(UUID id, V entity){
        return new Persistable(id, entity);
    }
}
