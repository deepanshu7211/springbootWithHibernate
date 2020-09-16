package com.jpa.hibernate.SpringbootWithJpaHibernate.repository;

import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Course;
import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Passport;
import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

//    Entity Manager used Transactional annotation to save all the data.
//    @Transactional will use PersistenceCOntext and it will track what are entities need to be saved.

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }

//    Need to add @Transactional Annotation otherwise it will throw the below error
//  No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call

    public void deleteById(Long id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student){
        if(student.getId()==null){
            entityManager.persist(student);
        }
        else {
            entityManager.merge(student);
        }
        return student;
    }

    public void playWithEntityManager(){
        Student student = new Student("Student Springboot");
        entityManager.persist(student);
        entityManager.flush();
//        This will fire the update query as @Transaction is used it will consider as a single Txn.
        try {
            Thread.sleep(1000); // This to see difference b/w creation and updated timestamp
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student.setName("Student Springboot -Updated");
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("ZIN1234");
        entityManager.persist(passport);

        Student student = new Student("Student with Passport");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext() {
        //Database Operation 1 - Retrieve student
        Student student = entityManager.find(Student.class, 20001L);
        //Persistence Context (student)


        //Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        passport.setNumber("E123457");
        //Persistence Context (student, passport++)

        //Database Operation 4 - update student
        student.setName("Student - updated");
        //Persistence Context (student++ , passport++)
    }


    public void insertStudentAndCourse(){
     Student student = new Student("Student of microservices");
     Course course = new Course(" Spring boot with microservices in java");
     entityManager.persist(student);
     entityManager.persist(course);

     student.addCourse(course);
     course.addStudent(student);

     entityManager.persist(student);

    }
}
