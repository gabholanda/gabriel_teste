package com.gabriel.uberclone.repositories;

import com.gabriel.uberclone.entities.Driver;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
    Optional<Driver> findByCpf(String cpf);
}
