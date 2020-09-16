package com.jpa.hibernate.SpringbootWithJpaHibernate.repository;

import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Course;
import com.jpa.hibernate.SpringbootWithJpaHibernate.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }

//    Need to add @Transactional Annotation otherwise it will throw the below error
//  No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        if(course.getId()==null){
            entityManager.persist(course);
        }
        else {
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        Course course = new Course("Spring boot with Mircroservices");
        entityManager.persist(course);
        entityManager.flush();
//        This will fire the update query as @Transaction is used it will consider as a single Txn.
        try {
            Thread.sleep(1000); // This to see difference b/w creation and updated timestamp
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        course.setName("Spring boot with Mircroservices -Updated");
    }

    public void addReviewsForCourse() {
        //Get Course
        Course course = findById(10001L);

//        Add reviews to the course
        Review review = new Review("awesome course","5");
        Review review1 = new Review("Best course","5");

        course.addReview(review);
        //Review is owning the relationship need to provide course id
        review.setCourse(course);
        course.addReview(review1);
        review1.setCourse(course);

        //save to db
        entityManager.persist(review);
        entityManager.persist(review1);


    }
}
