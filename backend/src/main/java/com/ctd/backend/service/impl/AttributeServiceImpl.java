package com.ctd.backend.service.impl;

import com.ctd.backend.model.Attribute;
import com.ctd.backend.repository.AttributeRepository;
import com.ctd.backend.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;


    @Override
    public Attribute saveAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public Optional<Attribute> findAttributeById(Long id) {
        return attributeRepository.findById(id);
    }

    @Override
    public Optional<Attribute> findAttributeByName(String name) {
        return attributeRepository.findByName(name);
    }

    @Override
    public void deleteAttribute(Long id) {
        attributeRepository.deleteById(id);
    }

    @Override
    public void updateAttribute(Attribute attribute) {
        attributeRepository.save(attribute);
    }

    @Override
    public List<Attribute> findAllAttributes() {
        return attributeRepository.findAll();
    }
}
