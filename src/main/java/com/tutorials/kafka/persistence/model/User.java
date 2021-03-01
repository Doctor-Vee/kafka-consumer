package com.tutorials.kafka.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String department;

    private String greeting;

}
