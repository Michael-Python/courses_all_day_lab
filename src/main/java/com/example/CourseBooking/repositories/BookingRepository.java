package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
