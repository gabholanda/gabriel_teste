package com.gabriel.uberclone.controllers;

import com.gabriel.uberclone.entities.Passenger;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.gabriel.uberclone.repositories.PassengerRepository;


@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    @Autowired
    PassengerRepository passengerRepo;
    
    @GetMapping
    public List<Passenger> findAll(){
        return passengerRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> findById(@PathVariable("id") int id) {
        Optional<Passenger> optPassenger = passengerRepo.findById(id);
        if(optPassenger.isPresent()) {
            return ResponseEntity.ok(optPassenger.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    // Not recommend and should be redone to pass by body
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Passenger> findByCpf(@PathVariable("cpf") String cpf) {
        Optional<Passenger> optPassenger = passengerRepo.findByCpf(cpf);
        if(optPassenger.isPresent()) {
            return ResponseEntity.ok(optPassenger.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping
    @ResponseBody
    public Passenger create(@RequestBody Passenger passenger) {
        return passengerRepo.save(passenger);
    }
}