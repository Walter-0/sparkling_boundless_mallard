package com.walteraugustine.sparkling_boundless_mallard.models;

import java.util.Collection;

public class List {
    private String name;
    private Collection<Card> cards;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Card> getCards() {
        return cards;
    }
}
