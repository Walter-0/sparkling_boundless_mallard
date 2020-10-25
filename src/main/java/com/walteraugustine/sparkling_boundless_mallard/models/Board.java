package com.walteraugustine.sparkling_boundless_mallard.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Optional;

@Document
public class Board {
    @Id
    private String id;
    private String name;
    private Collection<List> lists;
    private String owner;

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

//    public Optional<List> getListByName(String listName) {
//    }

    public void setList(Collection<List> list) {
        this.lists = list;
    }

    public void addList(List newList) {
        this.lists.add(newList);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) { this.owner = owner;}
}