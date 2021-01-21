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
//            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "name") String name

    ){
        //if you don't know about the parameters put the one with the most conditions first

        if(age != null && customerTown != null && name != null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, customerTown, name),HttpStatus.OK);
        }


        if(customerTown != null && name != null){
            return new ResponseEntity(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(customerTown, course),HttpStatus.OK);
        }

        if(age!= null){
            return new ResponseEntity(customerRepository.findByAgeGreaterThan(age), HttpStatus.OK);
        }

        if(name!= null){
            return new ResponseEntity(customerRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }

        if(course != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }



        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}
