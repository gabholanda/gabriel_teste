package com.gabriel.uberclone.enums;

import com.fasterxml.jackson.annotation.JsonValue;


public enum Genders {
    Masculine("Masculino"),
    Feminine("Feminino"),
    Others("Outros");
    
    private String sexName;
    private Genders(String sex) {
        this.sexName = sex;
    }
    
    @Override
    @JsonValue
    public String toString(){
        return sexName;
    }
    
}

