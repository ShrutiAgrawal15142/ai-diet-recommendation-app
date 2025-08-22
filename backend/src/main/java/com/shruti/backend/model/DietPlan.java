package com.shruti.backend.model;
import java.util.List;
public class DietPlan {
    private String breakfast;
    private String lunch;
    private String dinner;
    private List<String> snacks;

    public DietPlan(String breakfast, String lunch, String dinner, List<String> snacks) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snacks = snacks;
    }

    // Getters
    public String getBreakfast() { return breakfast; }
    public String getLunch() { return lunch; }
    public String getDinner() { return dinner; }
    public List<String> getSnacks() { return snacks; }
}
