package com.gabriel.uberclone.controllers;

import com.gabriel.uberclone.entities.Race;
import com.gabriel.uberclone.repositories.RaceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/race")
public class RaceController {
    @Autowired
            RaceRepository raceRepo;
    
    @GetMapping
    public List<Race> findAll() {
        return raceRepo.findAll();
    }
    
    @PostMapping
    @ResponseBody
    public ResponseEntity<Race> create(@RequestBody Race race) {
        if(race.getDriver().isActive())
            return ResponseEntity.ok(raceRepo.save(race));
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    
}
