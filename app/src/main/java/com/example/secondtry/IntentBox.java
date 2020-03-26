package com.example.secondtry;

import java.io.Serializable;

public class IntentBox implements Serializable {
   public boolean fromChubriki;
   public String stroka;



    public IntentBox(boolean fromChubriki, String stroka) {
        this.fromChubriki = fromChubriki;
        this.stroka = stroka;
    }
}
