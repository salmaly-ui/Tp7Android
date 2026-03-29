package com.example.mystars.models;

public class Celebrity {
    private int id;
    private String name;
    private int imageResId;   // ← int, pas String
    private float rating;
    private static int counter = 0;

    public Celebrity(String name, int imageResId, float rating) {
        this.id = ++counter;
        this.name = name;
        this.imageResId = imageResId;
        this.rating = rating;
    }

    // Getters / Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public float getRating() { return rating; }
    public void setName(String name) { this.name = name; }
    public void setImageResId(int imageResId) { this.imageResId = imageResId; }
    public void setRating(float rating) { this.rating = rating; }
}