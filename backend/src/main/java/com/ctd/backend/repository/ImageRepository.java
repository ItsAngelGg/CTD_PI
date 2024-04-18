package com.ctd.backend.repository;

import com.ctd.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    //Create methods custom below 🡫
}
