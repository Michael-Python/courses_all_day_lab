package com.example.CourseBooking.controllers;

import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "course") String course,
            @RequestParam(required = false, name = "customerTown") String customerTown,
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "age") Integer age

    ){
        if(course != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }

        if(age == null && customerTown != null && courseName != null){
            return new ResponseEntity(customerRepository.findByTownAndBookingsCourseName(customerTown, courseName),HttpStatus.OK);
        }

        if(age != null && customerTown != null && courseName != null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, customerTown, courseName),HttpStatus.OK);
        }


        if(age!= null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThan(age), HttpStatus.OK);
        }


        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
