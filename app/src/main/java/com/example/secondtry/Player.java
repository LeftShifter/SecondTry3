package com.example.secondtry;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int money;
    private int science;
    private int Sch;
    private int Mch;
    private Chubrik Rabotyaga;
    private Chubrik Umnik;
    private Chubrik Solider;

    private ArrayList Chubriki = new ArrayList();


    private Technologies[] technologies = new Technologies[12];

    public Technologies getTechnologies(int i) {
        return technologies[i];
    }

    public void setTechnologies(Technologies[] technologies) {
        this.technologies = technologies;
    }


    public ArrayList getChubriki() {
        return Chubriki;
    }

    public void setChubriki(ArrayList chubriki) {
        Chubriki = chubriki;
    }

    public Player() {
        Chubriki.add(new Chubrik(100,150,30,75,"Rabotyaga",R.drawable.rabotyaga,1));
        Chubriki.add(new Chubrik(150,35,100,25,"Umnik",R.drawable.umnik,2));
        Chubriki.add(new Chubrik(170,100,65,85,"Soldier",R.drawable.soldier,3));
       // Rabotyaga = new Chubrik();
        //Umnik = new Chubrik();
        //Solider = new Chubrik();
        money = 100;
        science = 100;
        Sch = 3;
        Mch = 3;
        technologies[0] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[1] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[2] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[3] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[4] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[5] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[6] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[7] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[8] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[9] = new Technologies(100, "тестовая технология описание даже не увидишь");
        technologies[10] = new Technologies(200, "тестовая технология описание даже не увидишь");
        technologies[11] = new Technologies(200, "тестовая технология описание даже не увидишь");
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setSch(int sch) {
        Sch = sch;
    }

    public void setMch(int mch) {
        Mch = mch;
    }

    public int getMoney() {
        return money;
    }

    public int getScience() {
        return science;
    }

    public int getSch() {
        return Sch;
    }

    public int getMch() {
        return Mch;
    }

    public Chubrik getRabotyaga() {
        return Rabotyaga;
    }

    public void setRabotyaga(Chubrik rabotyaga) {
        Rabotyaga = rabotyaga;
    }

    public Chubrik getUmnik() {
        return Umnik;
    }

    public void setUmnik(Chubrik umnik) {
        Umnik = umnik;
    }

    public Chubrik getSolider() {
        return Solider;
    }

    public void setSolider(Chubrik solider) {
        Solider = solider;
    }

    public Technologies[] getTechnologies() {
        return technologies;
    }
}
