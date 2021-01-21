package com.example.CourseBooking;

import com.example.CourseBooking.models.Booking;
import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.BookingRepository;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
		assertEquals(3, bookingRepository.findAll().size());
	}


	@Test
	public void canGetCoursesByRating(){
		List<Course> foundCourses = courseRepository.findByRating(2);
		assertEquals("Javascript", foundCourses.get(0).getName());
	}

	@Test
	public void canGetAllCustomersForCourse(){
		List<Customer> foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase("Python Programming");
		assertEquals(2, foundCustomers.size());
	}

	@Test
	public void canGetAllCoursesForCustomer(){
		List<Course> foundCourses = courseRepository.findByBookingsCustomerNameIgnoreCase("Emily");
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void canGetAllBookingsByDate(){
		List<Booking> foundBookings = bookingRepository.findByDate("04-05-21");
		assertEquals(1, foundBookings.size());
	}

}
