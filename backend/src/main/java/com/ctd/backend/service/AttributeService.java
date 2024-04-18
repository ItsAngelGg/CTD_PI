package com.ctd.backend.service;

import com.ctd.backend.model.Attribute;

import java.util.List;
import java.util.Optional;

public interface AttributeService {

    Attribute saveAttribute(Attribute attribute);
    Optional<Attribute> findAttributeById(Long id);
    Optional<Attribute> findAttributeByName(String name);
    void deleteAttribute(Long id);
    void updateAttribute(Attribute attribute);
    List<Attribute> findAllAttributes();
}
