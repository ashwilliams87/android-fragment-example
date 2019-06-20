package com.ashwilliams87.bitsandpizzas.models;

import com.ashwilliams87.bitsandpizzas.R;

public class Pasta {
    private String name;
    private int ImageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spag_bol),
            new Pasta("Lasagne", R.drawable.lasagne),
    };

    public Pasta(String name, int imageResourceId) {
        this.name = name;
        ImageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }
}
