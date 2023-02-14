package com.kkjavatutorials.SpringBootRestApp.service;



import com.kkjavatutorials.SpringBootRestApp.model.AppleCardModel;

import java.util.List;
import java.util.Optional;

public interface AppleCardService {
    List<AppleCardModel>findAllCard();
    Optional<AppleCardModel> findById(Long id);
    AppleCardModel saveCard(AppleCardModel appleCardModel);
    void deleteCard(Long id);

    AppleCardModel digitizeCards(Long id);

    AppleCardModel agreeCards(Long id);
}
