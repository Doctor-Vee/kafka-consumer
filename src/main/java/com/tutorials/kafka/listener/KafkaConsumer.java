package com.tutorials.kafka.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorials.kafka.payload.EmployeeEvent;
import com.tutorials.kafka.payload.UserEvent;
import com.tutorials.kafka.persistence.EmployeeRepository;
import com.tutorials.kafka.persistence.model.Employee;
import com.tutorials.kafka.persistence.model.User;
import com.tutorials.kafka.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final String MESSAGE_TOPIC = "MESSAGE_TOPIC";
    private static final String USER_TOPIC = "USER_TOPIC";
    private static final String EMPLOYEE_TOPIC = "EMPLOYEE_TOPIC";

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @KafkaListener(topics = MESSAGE_TOPIC, groupId = "group_id2")
    public void consumeString(String message){
        System.out.println("Message Event: " + message);
    }

    @KafkaListener(topics = USER_TOPIC, groupId = "user_event")
    public void consumeUserEvent(String userEventString){
        System.out.println("UserEvent: " + userEventString);
        UserEvent userEvent = new UserEvent();
        ObjectMapper mapper = new ObjectMapper();
        try{
        userEvent = mapper.readValue(userEventString, UserEvent.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        User user = new User(userEvent.getName(), userEvent.getDepartment(), userEvent.getGreeting());
        userRepository.save(user);
    }

    @KafkaListener(topics = EMPLOYEE_TOPIC, groupId = "user_event")
    public void consumeEmployeeEvent(String employeeEventString){
        System.out.println("Employee Event: " + employeeEventString);
        EmployeeEvent employeeEvent = new EmployeeEvent();
        ObjectMapper mapper = new ObjectMapper();
        try{
            employeeEvent = mapper.readValue(employeeEventString, EmployeeEvent.class);
        } catch (Exception e){
            e.printStackTrace();
        }
        Employee employee = new Employee(employeeEvent.getName(), employeeEvent.getJobRole(), employeeEvent.getSalary());
        employeeRepository.save(employee);
    }
}
