package com.kkjavatutorials.SpringBootRestApp.controller;



import com.kkjavatutorials.SpringBootRestApp.Repo.AuditLogDao;
import com.kkjavatutorials.SpringBootRestApp.Repo.RelationshipDetailsRepository;
import com.kkjavatutorials.SpringBootRestApp.model.AppleCardModel;
import com.kkjavatutorials.SpringBootRestApp.model.AuditLog;
import com.kkjavatutorials.SpringBootRestApp.model.RelationshipDetails;
import com.kkjavatutorials.SpringBootRestApp.service.AppleCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/applecards")
public class AppleCardController {

    private final AppleCardService appleCardService;
    Logger logger = LoggerFactory.getLogger(AppleCardController.class);

    @Autowired
    AuditLogDao auditLogDao;

    @Autowired
    RelationshipDetailsRepository relationshipDetailsRepository;

    public AppleCardController(AppleCardService appleCardService) {
        this.appleCardService = appleCardService;
    }

    @GetMapping
    public List<AppleCardModel> findAllCard() {
        return appleCardService.findAllCard();
    }

    @PostMapping("/id")
    public Optional<AppleCardModel> findById(@RequestBody AppleCardModel id) {
       Long Id= id.getId();
        return appleCardService.findById(Id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AppleCardModel saveCard(@RequestBody AppleCardModel appleCardModel) {
        logger.info("Successfully tokenized card With Service Provider (TSPC)");
        AuditLog auditLog = new AuditLog();
        long id = appleCardModel.getId();
        RelationshipDetails relationshipDetails = relationshipDetailsRepository.findById(id).get();

        auditLog.setStatus("Endpoint :- /applecards" );
        auditLog.setRequest("Successfully tokenized Card - "+ relationshipDetails.getRelationshipnumber()+ " Customer Name - " + relationshipDetails.getCustomerName()+ " "+ "with token requestor");
        auditLogDao.save(auditLog);


        return appleCardService.saveCard(appleCardModel);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id")
    public void deleteCard(@RequestBody AppleCardModel id) {
        Long Id= id.getId();
        appleCardService.deleteCard(Id);
    }

    @PostMapping("/details/digitize/id")
    AppleCardModel digitizeCards(@RequestBody AppleCardModel id) {
        Long Id= id.getId();
        return appleCardService.digitizeCards(Id);

    }

    @PostMapping("/details/agreed/id")
    AppleCardModel agreeCards(@RequestBody AppleCardModel id) {
        Long Id= id.getId();
        return appleCardService.agreeCards(Id);

    }


}
