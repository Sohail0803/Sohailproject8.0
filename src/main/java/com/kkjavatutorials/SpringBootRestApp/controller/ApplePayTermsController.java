package com.kkjavatutorials.SpringBootRestApp.controller;


import com.kkjavatutorials.SpringBootRestApp.Repo.AuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.Repo.TRSAuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.model.Apple;
import com.kkjavatutorials.SpringBootRestApp.model.AuditLog;
import com.kkjavatutorials.SpringBootRestApp.model.TRSAuditLogModel;
import com.kkjavatutorials.SpringBootRestApp.service.AppleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ApplePayTermsController {

    Logger logger = LoggerFactory.getLogger(ApplePayTermsController.class);

    @Autowired
    AuditLogDao auditLogDao;

    @Autowired
    TRSAuditLogDao trs;

    @Autowired
    private AppleService appleServiceimpl;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "saveApple")
    public Apple saveApple(@RequestBody Apple apple) {
        appleServiceimpl.saveApple(apple);
        return apple;
    }

    @GetMapping(value = "getall")
    public List<Apple> findAllApple() {

        logger.info("Token Requestor (ApplePay) raised request to get terms and conditions. (TSPC)");
        AuditLog auditLog = new AuditLog();
        auditLog.setRequest("Token Requestor (ApplePay) raised request to get terms and conditions. ");
        auditLog.setSuccessfull_request("Token Requestor (ApplePay) successfully fetched terms and conditions. ");
        auditLog.setStatus("Endpoint :- /getall");
        auditLogDao.save(auditLog);

        TRSAuditLogModel trsauditlog = new TRSAuditLogModel();
        trsauditlog.setRequest("Request raised for getting the Terms and Conditions ");
        trsauditlog.setStatus("Endpoint :- /getall");
        trs.save(trsauditlog);

        return appleServiceimpl.findAllApples();
    }

    @PostMapping("get/id")
    public Apple getAppleById(@RequestBody Apple Id) {
         Long id=Id.getId();
        return appleServiceimpl.getAppleById(id);
    }

    @PutMapping("update")
    public Apple updateApple(@RequestBody Apple apple) {
        return appleServiceimpl.updateApple(apple);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("delete/id")
    public String deleteApple(@RequestBody Apple Id) {
        Long id=Id.getId();
        appleServiceimpl.deleteApple(id);
        return "Deleted";
    }

    @PutMapping("update/id")
    public Apple updateById(@RequestBody Apple apple) {
       Long id= apple.getId();
        return appleServiceimpl.updateById(id, apple);
    }

}
