package com.example.apptest.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fruit {

    private String name;

    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
}
