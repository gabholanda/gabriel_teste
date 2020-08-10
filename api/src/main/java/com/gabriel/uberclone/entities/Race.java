package com.gabriel.uberclone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Race {
        
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    @ManyToOne
    @JoinColumn
    private Passenger passenger;
    @NotNull
    @ManyToOne
    @JoinColumn
    private Driver driver;
    @Positive
    @Min(value=0, message="Valor da corrida nao pode ser menor do que 0")
    private double value;

    public Race() {
    }

    public Race(Passenger passenger, Driver driver, double value) {
        this.passenger = passenger;
        this.driver = driver;
        this.value = value;
    }

    public Race(int id, Passenger passenger, Driver driver, double value) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
