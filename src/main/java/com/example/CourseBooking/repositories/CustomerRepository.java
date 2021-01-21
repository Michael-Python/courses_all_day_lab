package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String customerTown, String course);

    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String customerTown, String course);

    List<Customer> findByAgeGreaterThan(int age);

    List<Customer> findByNameIgnoreCase(String name);
}
