package com.example.employeevalidation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNums;
    private String doj;
    private Long salary;
}