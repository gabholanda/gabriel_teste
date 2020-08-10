package com.gabriel.uberclone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.uberclone.enums.Genders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Passenger extends Person{

    public Passenger() {
    }

    public Passenger(String name, String cpf, Genders sex, LocalDate birthdate) {
        super(name, cpf, sex, birthdate);
    }

    public Passenger(int id, String name, String cpf, Genders sex, LocalDate birthdate) {
        super(id, name, cpf, sex, birthdate);
    }
    
    @JsonIgnore
    @OneToMany(mappedBy="passenger")
    private List<Race> races = new ArrayList();
    
    public List<Race> getRaces() {
        return races;
    }
    
}
