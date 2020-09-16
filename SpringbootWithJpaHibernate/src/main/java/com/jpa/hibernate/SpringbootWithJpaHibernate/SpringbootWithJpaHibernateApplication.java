package com.jpa.hibernate.SpringbootWithJpaHibernate;

import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Course;
import com.jpa.hibernate.SpringbootWithJpaHibernate.repository.CourseRepository;
import com.jpa.hibernate.SpringbootWithJpaHibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWithJpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		courseOperations();
		studentOperations();
	}

	public void studentOperations(){
//		studentRepository.saveStudentWithPassport();
		studentRepository.insertStudentAndCourse();
	}

	public void courseOperations()
	{
//		Course course = courseRepository.findById(10001L);
//		logger.info(" course ============= " + course);

//		courseRepository.deleteById(10001L);
//		logger.info(" course 10001L deleted ============= " );

//		courseRepository.save(new Course("Microservice with hibernate"));
//		courseRepository.playWithEntityManager();

//		courseRepository.addReviewsForCourse();
	}
}
