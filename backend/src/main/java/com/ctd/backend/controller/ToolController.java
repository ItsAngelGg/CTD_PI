package com.ctd.backend.controller;

import com.ctd.backend.exceptions.DuplicatedValueException;
import com.ctd.backend.exceptions.ResourceNotFoundException;
import com.ctd.backend.model.Tool;
import com.ctd.backend.repository.ToolRepository;
import com.ctd.backend.service.impl.CategoryServiceImpl;
import com.ctd.backend.service.impl.ToolServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tools")
@Tag(name = "Tools", description = "CRUD of tool entity")
public class ToolController {

    private final ToolServiceImpl toolService;
    private final CategoryServiceImpl categoryService;
    private final ToolRepository toolRepository;

    @Autowired
    public ToolController (ToolServiceImpl toolService,
                            CategoryServiceImpl categoryService,
                            ToolRepository toolRepository) {
        this.categoryService = categoryService;
        this.toolService = toolService;
        this.toolRepository = toolRepository;
    }

    /* Search methods */
    @GetMapping("/list")
    public ResponseEntity<List<Tool>> getAllTools(){
        return ResponseEntity.ok(toolService.getAllTools());
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<Optional<Tool>> getToolById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Tool> toolRequired = toolService.getToolById(id);
        if(toolRequired.isPresent()){
            return ResponseEntity.ok(toolRequired);
        } else {
            throw new ResourceNotFoundException("The tool with the given ID wasn't found");
        }
    }
    @GetMapping("/list/{name}")
    public ResponseEntity<Optional<Tool>> getToolByName(@PathVariable String name) throws ResourceNotFoundException {
        Optional<Tool> toolRequired = toolService.getToolByName(name);
        if(toolRequired.isPresent()){
            return ResponseEntity.ok(toolRequired);
        } else {
            throw new ResourceNotFoundException("The tool with the given ID wasn't found");
        }
    }


    /* Create */
    @PostMapping("/create")
    public ResponseEntity<Tool> createTool(@RequestBody Tool tool) throws DuplicatedValueException {
        Optional<Tool> toolRequired = toolService.getToolByName(tool.getName());
        if(toolRequired.isPresent()){
            throw new DuplicatedValueException("There's already a tool with that name");
        } else {
            return ResponseEntity.ok(toolService.saveTool(tool));
        }
    }

    /* Delete */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTool(@PathVariable Long id) throws ResourceNotFoundException {
        return toolService.getToolById(id)
                .map(tool -> {
                    toolService.deleteToolById(id);
                    return ResponseEntity.ok("The tool was successfully removed");
                })
                .orElseThrow(() -> new ResourceNotFoundException("The tool with the given ID wasn't found"));
    }

    /* Update */
    @PutMapping("/update")
    public ResponseEntity<String> updateTool(@RequestBody Tool tool) throws ResourceNotFoundException {
        Optional<Tool> toolRequired = toolService.getToolById(tool.getId());
        if(toolRequired.isPresent()){
            toolService.updateTool(tool);
            return ResponseEntity.ok("The tool was successfully updated");
        } else {
            throw new ResourceNotFoundException("The tool with the given ID wasn't found");
        }
    }


}
