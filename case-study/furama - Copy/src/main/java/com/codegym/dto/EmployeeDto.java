package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer employeeId;
    private String employeeName;
    private String dateOfBirth;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private Integer position;
    private Integer educationDegree;
    private Integer division;

}
