package com.ctd.backend.service.impl;

import com.ctd.backend.model.Category;
import com.ctd.backend.model.Tool;
import com.ctd.backend.repository.ToolRepository;
import com.ctd.backend.service.ToolService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Override
    public List<Tool> getAllTools() {
       return toolRepository.findAll();
    }

    @Override
    public Optional<Tool> getToolById(Long id) {
        return toolRepository.findById(id);
    }
    //Ver luego
    @Override
    public List<Tool> getToolsByCategory(Category id) {
        return null;
    }

    @Override
    public Tool saveTool(Tool tool) {
        return toolRepository.save(tool);
    }

    @Override
    public Tool updateTool(Tool tool) {
        return toolRepository.save(tool);
    }

    @Override
    public void deleteToolById(Long id) {
        toolRepository.deleteById(id);
    }
}
