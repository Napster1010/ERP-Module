package com.erp.services;

import com.erp.beans.Review;
import com.erp.beans.StudentCourseEnrollment;
import com.erp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private StudentCourseEnrollmentService studentCourseEnrollmentService;

    public Review addReview(Review review){
        Review insertedReview = reviewRepository.save(review);
        return insertedReview;
    }

    public Review updateReview(Review review){
        if(reviewRepository.existsById(review.getId()))
        {
            Review updatedReview = reviewRepository.save(review);
            return updatedReview;
        }
        else
            return null;
    }

    public boolean deleteReview(Review review){
        try {
            reviewRepository.delete(review);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Review getByStudentCourseEnrollmentId(Long studentCourseEnrollmentId){
        StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentService.getStudentCourseEnrollmentById(studentCourseEnrollmentId);
        Review review = reviewRepository.findByStudentCourseEnrollment(studentCourseEnrollment);
        return review;
    }
}
