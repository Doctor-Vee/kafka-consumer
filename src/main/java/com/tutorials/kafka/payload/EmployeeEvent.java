package com.tutorials.kafka.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEvent {

    private String name;

    private String jobRole;

    private Double salary;

}
