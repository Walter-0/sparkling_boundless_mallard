package com.walteraugustine.sparkling_boundless_mallard.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class Board {
    @Id
    private String id;
    private String name;
    private Collection<List> lists;

    public String getId() {
        return id;
    }

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