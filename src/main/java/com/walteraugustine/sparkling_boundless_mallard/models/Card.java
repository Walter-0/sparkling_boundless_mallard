package com.walteraugustine.sparkling_boundless_mallard.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Card {
    @Id
    private String id;
    private String name;
    private String description;
    private List currentList;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getCurrentList() {
        return currentList;
    }

    public void setCurrentList(List currentList) {
        this.currentList = currentList;
    }
}
