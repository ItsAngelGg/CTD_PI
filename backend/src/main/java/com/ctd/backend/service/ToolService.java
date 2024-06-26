package com.ctd.backend.service;

import com.ctd.backend.model.Category;
import com.ctd.backend.model.Tool;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ToolService {
    List<Tool> getAllTools();
    Optional<Tool> getToolById(Long id);
    Optional<Tool> getToolByName(String name);
    List<Tool> getToolsByCategory(Category id);
    Tool saveTool(Tool tool);
    Tool updateTool(Tool tool);
    void deleteToolById(Long id);

}
