package com.example.CourseBooking.components;


import com.example.CourseBooking.models.Booking;
import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.BookingRepository;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        Course course1 = new Course("Python Programming", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Javascript", "Glasgow", 2);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Michael", "Edinburgh", 45);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Emily", "Edinburgh", 28);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("01-02-21", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-02-21", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("04-05-21", course2, customer2);
        bookingRepository.save(booking3);
    }

}
