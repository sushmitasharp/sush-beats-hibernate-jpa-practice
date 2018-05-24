package com.learn.jpa.hibernate.database.demo;

import com.learn.jpa.hibernate.database.demo.entity.*;
import com.learn.jpa.hibernate.database.demo.repository.CourseRepository;
import com.learn.jpa.hibernate.database.demo.repository.EmployeeRepository;
import com.learn.jpa.hibernate.database.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Course course = repository.findById(10001L);
		logger.info("Course 10001->{}", course);
		//repository.deleteById(10001L);
		repository.save(new Course("Microservices in 100 steps"));*/
		//repository.playWithEnsaveStudentWithPassporttityManager();
		//studentRepository.saveStudentWithPassport();

		//courseRepository.addHardcodedReviewsForCourse();

		/*List<Review> reviews = new ArrayList<>();

		reviews.add(new Review("5", "Great Hands-on Stuff."));
		reviews.add(new Review("5", "Hatsoff."));

		courseRepository.addReviewsForCourse(10003L, reviews );*/

		/*studentRepository.insertHardcodedStudentAndCourse();*/

		/*studentRepository.insertStudentAndCourse(new Student("Jack"),
				new Course("Microservices in 100 Steps"));*/

		// Jack FullTimeEmployee salary - 10000$
		// Jill PartTimeEmployee - 50$ per hour
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
	}


}
