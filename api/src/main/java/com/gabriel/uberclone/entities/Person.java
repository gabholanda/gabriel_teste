
package com.gabriel.uberclone.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.uberclone.enums.Genders;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public abstract class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @Column(unique=true)
    @NotBlank
    @Size(min=11, max=11, message="CPF obrigatoriamente tem de ser 11 caracteres")
    @CPF(message="CPF Invalido")
    private String cpf;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Genders sex;
    @NotNull
    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthdate;
    
    public Person() {
    }

    public Person(String name, String cpf, Genders sex, LocalDate birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.birthdate = birthdate;
    }

    
    public Person(int id, String name, String cpf, Genders sex, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.birthdate = birthdate;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genders getSex() {
        return sex;
    }

    public void setSex(Genders sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}


