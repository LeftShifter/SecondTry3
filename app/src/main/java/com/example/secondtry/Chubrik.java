package com.example.secondtry;

import android.provider.ContactsContract;

import java.io.Serializable;

public class Chubrik implements Serializable {
    private int id;
    private int cost;
    private int physical;
    private int intelligence;
    private int loyalty;
    private Gen Gen[] = new Gen[8];
    private String name;
    private  int imageID;



    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Chubrik(int cost, int physical, int intelligence, int loyalty, String name, int ImageId, int id) {
        this.cost = cost;
        this.physical = physical;
        this.intelligence = intelligence;
        this.loyalty = loyalty;
        this.name = name;
        this.imageID = ImageId;
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLoyalt() {
        return loyalty;
    }

    public void setLoyalt(int loyalt) {
        this.loyalty = loyalt;
    }

    public com.example.secondtry.Gen[] getGen() {
        return Gen;
    }

    public void setGen(Gen gen,int numb) {
        Gen[numb] = gen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
