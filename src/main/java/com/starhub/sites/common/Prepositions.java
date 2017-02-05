package com.starhub.sites.common;

public enum Prepositions {
    IN("IN"),
    ON("ON"),
    FROM("FROM");

    private String preposition;

    Prepositions(String preposition) {
        this.preposition = preposition;
    }

    public String getPreposition() {
        return preposition;
    }
}
