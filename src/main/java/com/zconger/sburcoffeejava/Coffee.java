package com.zconger.sburcoffeejava;

import java.util.UUID;

class Coffee {
    private final String id;    // the ID of the coffee (final, so it's a constant)
    private String name;        // the name of the coffee

    public Coffee(String id, String name) {     // constructor
        this.id = id;
        this.name = name;
    }

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);   // constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    // there is no setId because the ID for a coffee object is immutable
}
