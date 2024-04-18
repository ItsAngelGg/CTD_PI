package com.ctd.backend.repository;

import com.ctd.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Create the custom methods below 🡫
    Optional<Category> findByName(String name);
}
