package com.data.techMap.repository;

import com.data.techMap.entity.CollegeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepo extends JpaRepository<CollegeData, Long> {
    // Custom queries can be added here if needed
}
