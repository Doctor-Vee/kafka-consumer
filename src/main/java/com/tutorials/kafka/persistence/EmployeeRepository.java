package com.tutorials.kafka.persistence;

import com.tutorials.kafka.persistence.model.Employee;
import com.tutorials.kafka.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
