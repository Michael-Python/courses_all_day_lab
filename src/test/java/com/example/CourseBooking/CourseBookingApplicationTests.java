package com.example.CourseBooking;

import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.BookingRepository;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase
@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCustomerById(){
		Customer foundCustomer = customerRepository.getOne(1L);
		assertEquals("Michael", foundCustomer.getName() );
	}

	@Test
	public void canGetAllBookings(){
		assertEquals(2, bookingRepository.findAll().size());
	}
}
