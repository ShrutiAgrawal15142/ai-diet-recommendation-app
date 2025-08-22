package com.shruti.backend.model;

public class DietRequest {
    private int age;
    private double weight;
    private double height;
    private String goal;               // e.g., weight_loss, muscle_gain
    private String dietaryPreference;  // e.g., veg, non-veg, vegan

    // Getters and Setters
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public String getPreference() { return dietaryPreference; }
    public void setPreference(String dietaryPreference) { this.dietaryPreference = dietaryPreference; }
}
