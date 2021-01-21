package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
