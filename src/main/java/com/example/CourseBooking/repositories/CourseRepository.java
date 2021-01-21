package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
