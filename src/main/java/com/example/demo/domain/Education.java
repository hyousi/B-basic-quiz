package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Education {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Long year;

    @NotNull
    @Size(min = 1, max = 256)
    private String title;

    @NotNull
    @Size(min = 1, max = 4096)
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;
}