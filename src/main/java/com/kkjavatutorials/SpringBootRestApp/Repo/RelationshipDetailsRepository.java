package com.kkjavatutorials.SpringBootRestApp.Repo;


import com.kkjavatutorials.SpringBootRestApp.model.RelationshipDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipDetailsRepository extends JpaRepository<RelationshipDetails, Long> {
}
