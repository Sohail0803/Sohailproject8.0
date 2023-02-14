package com.kkjavatutorials.SpringBootRestApp.Repo;


import com.kkjavatutorials.SpringBootRestApp.model.TRSAuditLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TRSAuditLogDao extends JpaRepository<TRSAuditLogModel, Long> {

    List<TRSAuditLogModel> findAllByOrderByIdDesc();

}
