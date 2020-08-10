package com.gabriel.uberclone.repositories;

import com.gabriel.uberclone.entities.Passenger;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer>{
    Optional<Passenger> findByCpf(String cpf);
}
