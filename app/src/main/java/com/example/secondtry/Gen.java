package com.example.secondtry;

public class Gen {
    private String name = "ген1";
    private int cost = 100;
    private int costMeaning =15;
    private int id;

    private String Descritpion="стоит 100науки "+"\n"+"повышает стоимость чубриков на 15 денег"+"\n"+"тестовая штука";

    public Gen(int id) {
        this.id = id;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCostMeaning() {
        return costMeaning;
    }

    public void setCostMeaning(int costMeaning) {
        this.costMeaning = costMeaning;
    }




    public String getDescritpion() {
        return Descritpion;
    }

    public void setDescritpion(String descritpion) {
        Descritpion = descritpion;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
