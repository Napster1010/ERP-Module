package com.erp.repositories;

import com.erp.beans.Student;
import com.erp.beans.StudentDiscussionForumMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDiscussionForumMappingRepository extends JpaRepository<StudentDiscussionForumMapping, Long> {

    public List<StudentDiscussionForumMapping> findByStudent(Student student);
}
