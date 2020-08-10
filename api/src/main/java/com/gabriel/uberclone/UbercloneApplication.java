package com.gabriel.uberclone;

import com.gabriel.uberclone.entities.Driver;
import com.gabriel.uberclone.entities.Passenger;
import com.gabriel.uberclone.entities.Race;
import com.gabriel.uberclone.enums.Genders;
import com.gabriel.uberclone.repositories.DriverRepository;
import com.gabriel.uberclone.repositories.RaceRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import com.gabriel.uberclone.repositories.PassengerRepository;

@SpringBootApplication
public class UbercloneApplication {
    
    @Autowired
    private DriverRepository driverRepo;
    @Autowired
    private PassengerRepository personRepo;
    @Autowired
    private RaceRepository raceRepo;
    
    @EventListener
    public void createAllRolesOnInit(ContextRefreshedEvent ctx) {
        Driver driver = new Driver(true, "Modelo", "Joaozinho", "12345678909", Genders.Masculine, LocalDate.of(1990, 10, 2));
        Passenger person = new Passenger("Mariazinha", "22778286888", Genders.Feminine, LocalDate.of(1990, 10, 2));
        Race race = new Race(
                personRepo.save(person),
                driverRepo.save(driver),
                100);
        raceRepo.save(race);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(UbercloneApplication.class, args);
    }
    
}
