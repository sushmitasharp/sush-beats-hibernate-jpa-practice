package com.learn.jpa.hibernate.database.demo.repository;

import com.learn.jpa.hibernate.database.demo.DemoApplication;
import com.learn.jpa.hibernate.database.demo.entity.Course;
import com.learn.jpa.hibernate.database.demo.entity.Passport;
import com.learn.jpa.hibernate.database.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional  //without this annotation the passport details
	// could not be fetched due to no session present, this annotation extends the session for the whole method
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class,20001L);
		logger.info("student -> {}",student);
		logger.info("passport -> {}",student.getPassport());
	}

	@Test
	@Transactional  //without this annotation the passport details
	// could not be fetched due to no session present, this annotation extends the session for the whole method
	public void retrievePassportAndAssociatedStudentDetails() {
		Passport passport = em.find(Passport.class,40001L);
		logger.info("passport -> {}",passport);
		logger.info("student -> {}",passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses(){
		Student student = em.find(Student.class,20001L);

		logger.info("student->{}",student);
		logger.info("course->{}",student.getCourses());

		}


}
