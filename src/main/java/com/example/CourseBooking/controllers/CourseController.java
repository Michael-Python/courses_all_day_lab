package com.example.CourseBooking.controllers;

import com.example.CourseBooking.repositories.CourseRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity getAllCoursesAndFilters(
    @RequestParam(required = false, name = "rating") Integer rating,
    @RequestParam(required = false, name = "customer") String customer
    ){
        if(rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if(customer != null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerNameIgnoreCase(customer), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }



}
