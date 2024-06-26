package com.ctd.backend.repository;

import com.ctd.backend.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository <Tool, Long> {
    //Create custom methods below 🡫
    Optional<Tool> findByName(String name);
}
