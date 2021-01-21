package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String name);

    List<Customer> findByTownAndBookingsCourseName(String customerTown, String courseName);

    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String customerTown, String courseName);

    List<Customer> findByAgeGreaterThan(int age);
}
