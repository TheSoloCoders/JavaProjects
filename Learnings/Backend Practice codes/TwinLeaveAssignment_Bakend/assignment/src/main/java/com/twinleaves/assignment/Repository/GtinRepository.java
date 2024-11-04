package com.twinleaves.assignment.Repository;

import com.twinleaves.assignment.Entity.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GtinRepository extends JpaRepository<Gtin, Long> {
    Optional<Gtin> findByGtinCode(String gtinCode);


}
