package com.twinleaves.assignment.Repository;

import com.twinleaves.assignment.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
