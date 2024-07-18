package com.example.employeevalidation.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDTO {
    private Long employeeId;
    @NotNull(message="Firstname Should n't be null")
    @NotEmpty(message="Firstname Should n't be empty")
    private String firstName;
    @NotNull(message="Lastname Should n't be null")
    @NotEmpty(message="Lastname Should n't be empty")
    private String lastName;
    @Email(message="Enter valid email")
    private String email;
    private String phoneNums;
    @NotNull(message ="doj should not be null")
    @NotEmpty(message="doj should not be empty")
    private String doj;
    @NotNull(message ="salary should not be null" )
   // @NotEmpty(message="salary should not be empty")
    private Long salary;
}