package com.kkjavatutorials.SpringBootRestApp.Repo;


import com.kkjavatutorials.SpringBootRestApp.model.AppleCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleCardRepository extends JpaRepository<AppleCardModel, Long> {
}
