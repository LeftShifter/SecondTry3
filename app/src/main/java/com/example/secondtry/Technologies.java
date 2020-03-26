package com.example.secondtry;

import java.io.Serializable;

public class Technologies implements Serializable {

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private int cost;
    private String description;
    private boolean isResearched = false;

    public Technologies(int cost, String description) {
        this.cost = cost;
        this.description = description;


    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isResearched() {
        return isResearched;
    }

    public void setResearched(boolean researched) {
        isResearched = researched;
    }

    public boolean getResearched() {
        return this.isResearched;
    }


}
