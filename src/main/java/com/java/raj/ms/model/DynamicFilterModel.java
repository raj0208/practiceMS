package com.java.raj.ms.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonFilter("DynamicFilter")
public class DynamicFilterModel {
    private String firstName;
    private String lastName;
    private String department;
    private double salary;
}
