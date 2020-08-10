package com.gabriel.uberclone.controllers;

import com.gabriel.uberclone.entities.Driver;
import com.gabriel.uberclone.repositories.DriverRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/driver")
public class  DriverController {
    @Autowired
    DriverRepository driverRepo;
    
    @GetMapping
    public List<Driver> findAll() {
        return driverRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Driver> findById(@PathVariable("id") int id) {
        Optional<Driver> optDriver = driverRepo.findById(id);
        if(optDriver.isPresent()) {
            return ResponseEntity.ok(optDriver.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    // Not recommend and should be redone to pass by body
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Driver> findByName(@PathVariable("cpf") String cpf) {
        Optional<Driver> optDriver = driverRepo.findByCpf(cpf);
        if(optDriver.isPresent()) {
            return ResponseEntity.ok(optDriver.get());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    @ResponseBody
    public Driver create(@RequestBody Driver driver) {
        // Driver always start working, never on vacation
        driver.setIsActive(true);
        return driverRepo.save(driver);
    }
    
    @CrossOrigin
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Driver> update(@PathVariable("id")int id, @RequestBody boolean isActive) {
        Optional<Driver> optDriver = driverRepo.findById(id);
        if(optDriver.isPresent()) {
            Driver driver = optDriver.get();
            driver.setIsActive(isActive);
            driverRepo.save(driver);
            return ResponseEntity.ok(driver);
        } else {
            return (ResponseEntity<Driver>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    
}
