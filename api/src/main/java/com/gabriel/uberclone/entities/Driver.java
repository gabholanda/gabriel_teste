package com.gabriel.uberclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabriel.uberclone.enums.Genders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="driver")
public class Driver extends Person{
    @JsonProperty
    private boolean isActive;
    @NotBlank
    private String carModel;

    @JsonIgnore
    @OneToMany(mappedBy="driver")
    private List<Race> races = new ArrayList();
    
    public Driver() {
    }
    
    
    public Driver(boolean status, String carModel, String name, String cpf, Genders sex, LocalDate birthdate) {
        super(name, cpf, sex, birthdate);
        this.isActive = status;
        this.carModel = carModel;
    }

    public Driver(boolean status, String carModel, int id, String name, String cpf, Genders sex, LocalDate birthdate) {
        super(id, name, cpf, sex, birthdate);
        this.isActive = status;
        this.carModel = carModel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public List<Race> getRaces() {
        return races;
    }
    
    
}
