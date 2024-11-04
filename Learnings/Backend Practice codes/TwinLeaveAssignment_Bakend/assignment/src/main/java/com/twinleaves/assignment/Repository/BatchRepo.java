package com.twinleaves.assignment.Repository;

import com.twinleaves.assignment.Entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchRepo extends JpaRepository<Batch, Long> {
    @Query(value = "SELECT b.gtin_id FROM batch b WHERE b.available_quantity <= 0 ORDER BY b.inwarded_on DESC LIMIT 1", nativeQuery = true)
    Long findLatestGtinWithNegativeOrZeroBatchNative();

    @Query(value =  "SELECT SUM(b.available_quantity) from batch b WHERE b.available_quantity > 0 ORDER BY b.inwarded_on DESC LIMIT 3", nativeQuery = true)
    Integer topThreeNonPositiveBatches();
}
