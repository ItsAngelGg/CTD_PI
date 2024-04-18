package com.ctd.backend.repository;

import com.ctd.backend.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    //Create below the custom methods 🡫
    Optional<Attribute> findByName(String name);
}
