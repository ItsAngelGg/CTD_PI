package com.ctd.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long value;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    //@JsonIgnore
    private Set<Image> image;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "tool_attribute",
            joinColumns = @JoinColumn(name = "tool_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private List<Attribute> attribute = new ArrayList<>();
}
