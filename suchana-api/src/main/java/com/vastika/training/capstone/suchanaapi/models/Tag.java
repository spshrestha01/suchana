package com.vastika.training.capstone.suchanaapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tag")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(unique = true)
    @Size(min = 3, max = 20)
    private String name;
}
