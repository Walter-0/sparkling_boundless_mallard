package com.walteraugustine.sparkling_boundless_mallard.models;

import java.util.Collection;

public class BoardUpdatePayload {
    private String name;
    private Collection<List> lists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<List> getLists() {
        return lists;
    }

    public void setLists(Collection<List> lists) {
        this.lists = lists;
    }
}
