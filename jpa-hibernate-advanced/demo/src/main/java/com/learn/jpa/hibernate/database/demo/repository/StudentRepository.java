package com.learn.jpa.hibernate.database.demo.repository;

import com.learn.jpa.hibernate.database.demo.entity.Course;
import com.learn.jpa.hibernate.database.demo.entity.Passport;
import com.learn.jpa.hibernate.database.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    //public  Student findByID(Long id)
    public Student findById(Long id){
        return em.find(Student.class, id);
    }


    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
     Passport passport = new Passport("Z123456");
     em.persist(passport);


     Student student = new Student("Mike");
     student.setPassport(passport);
     em.persist(student);
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        //Student student = new Student("Jack");
        //Course course = new Course("Microservices in 100 Steps");
        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }




}
