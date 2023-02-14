package com.kkjavatutorials.SpringBootRestApp.service;


import com.kkjavatutorials.SpringBootRestApp.Repo.AppleCardRepository;
import com.kkjavatutorials.SpringBootRestApp.model.AppleCardModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppleCardServiceImpl implements AppleCardService {

    private final AppleCardRepository appleCardRepository;

    public AppleCardServiceImpl(AppleCardRepository appleCardRepository) {
        this.appleCardRepository = appleCardRepository;
    }

    @Override
    public List<AppleCardModel> findAllCard() {
        return appleCardRepository.findAll();
    }

    @Override
    public Optional<AppleCardModel> findById(Long id) {
        return appleCardRepository.findById(id);
    }

    @Override
    public AppleCardModel saveCard(AppleCardModel appleCardModel) {
        return appleCardRepository.save(appleCardModel);
    }

    @Override
    public void deleteCard(Long id) {
        appleCardRepository.deleteById(id);
    }

    @Override
    public AppleCardModel digitizeCards(Long id) {
        final AppleCardModel appleCardModel = appleCardRepository.findById(id).get();
        appleCardModel.setDigitized(true);
        return appleCardRepository.save(appleCardModel);
    }

    @Override
    public AppleCardModel agreeCards(Long id) {
        final AppleCardModel appleCardModel = appleCardRepository.findById(id).get();
        appleCardModel.setAgreed(true);
        return appleCardRepository.save(appleCardModel);
    }

}
