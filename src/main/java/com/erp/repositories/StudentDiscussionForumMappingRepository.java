package com.erp.repositories;

import com.erp.beans.StudentDiscussionForumMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDiscussionForumMappingRepository extends JpaRepository<StudentDiscussionForumMapping, Long> {
}
