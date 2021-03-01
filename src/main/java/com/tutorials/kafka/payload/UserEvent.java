package com.tutorials.kafka.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {

    private String name;

    private String department;

    private String greeting;

}
